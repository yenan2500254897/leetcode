package DFS;

import BFS.MaxCandies;

import java.util.*;

public class FrogPosition {
    //bfs解法
    public double frogPosition(int n, int[][] edges, int t, int target) {


        //visited[i]表示i是否被访问到
        boolean[] visited = new boolean[n+1];
        visited[1] = true;

        //probability[i]表示i被访问到的概率
        double[] probability = new double[n+1];

        Queue<Integer> currentLayer = new ArrayDeque<Integer>(1);
        Queue<Integer> assistant = new ArrayDeque<Integer>(1);

        //初始化
        currentLayer.add(1);
        int step = 0;
        probability[1] = 1.0;
        while (!currentLayer.isEmpty() && step<=t){

            int currentIndex = currentLayer.poll();

            System.out.println("index: " + currentIndex + " probablity: " + probability[currentIndex] + " step: " + step);

            //终止条件
            if(currentIndex == target){
                boolean flag = true;
                for(int[] edge:edges){
                    if ((edge[0] == currentIndex && visited[edge[1]] == false)
                            || edge[1] == currentIndex && visited[edge[0]] == false) {
                        flag = false;
                        break;
                    }
                }

                return (step == t || (step<t && flag))?probability[currentIndex]:0.0;
            }

            int nextTotal = 0;
            for(int[] edge:edges){
                if(edge[0] == currentIndex && visited[edge[1]] == false){
                    assistant.add(edge[1]);
                    System.out.println("add value: " + edge[1]);
                    visited[edge[1]] = true;
                    nextTotal++;
                }
                if(edge[1] == currentIndex && visited[edge[0]] == false){
                    assistant.add(edge[0]);
                    System.out.println("add value: " + edge[0]);
                    visited[edge[0]] = true;
                    nextTotal++;
                }
            }

            if(nextTotal!=0){
                for(int i=0;i<n+1;i++){
                    if(visited[i] == true && probability[i]==0.0){
                        probability[i] = probability[currentIndex]/nextTotal;
                    }
                }
            }

            if(currentLayer.isEmpty()){
                currentLayer.addAll(assistant);
                assistant.clear();
                step++;
            }
        }
        return 0;
    }

//    3
//    [[2,1],[3,2]]
//    1
//    2

    //dfs解法
    //map用于快速检索下一步可以到达的下标
    Map<Integer, List<Integer>> map ;
    //visited用于保证一个节点只能被访问一次
    boolean[] visited;
    //probability用于记录各个节点的概率
    double[] probability;
    public double frogPositionDfs(int n, int[][] edges, int t, int target) {
        //初始化
        map = new HashMap<Integer, List<Integer>>(n+1);
        visited = new boolean[n+1];
        probability = new double[n+1];

        for(int[] edge:edges){
            for(int i=0;i<2;i++){
                if(!map.containsKey(edge[i])){
                    List<Integer> initList = new ArrayList<>(1);
                    initList.add(edge[1-i]);
                    map.put(edge[i], initList);
                }else {
                    List<Integer> preList = map.get(edge[i]);
                    preList.add(edge[1-i]);
                    map.put(edge[i], preList);
                }
            }
        }
        visited[1] = true;
        probability[1] = 1.0;

        return dfs(1,0, t, target);
    }

    public double dfs(int index, int step, int stepLimit, int target){
        //记录下一个可到达节点的数目
        List<Integer> nextIndexList = map.get(index);
        int hasNext = 0;
        if(nextIndexList!=null && !nextIndexList.isEmpty()){
            for(Integer item:nextIndexList){
                if(visited[item] == false){
                    hasNext++;
                }
            }
        }

        //到达对应节点：需要比较用到的步数和限制使用的步数：如果用到的步数少于限制步数，但是无下一步节点可去，也是满足要求的
        if(index == target){
            return hasNext == 0 || step == stepLimit?probability[target]:0.0;
        }

        //步数使用完毕，还是没到目标节点
        if(step>=stepLimit){
            return 0.0;
        }

        //通过当前节点的概率计算下一步节点的概率
        double preProbability = probability[index];
        if(nextIndexList!=null && !nextIndexList.isEmpty()){
            for(Integer item:nextIndexList){
                if(visited[item] == false){
                    visited[item] = true;
                    probability[item] = preProbability/hasNext;
                    double result = dfs(item, step+1, stepLimit, target);
                    if(Math.abs(result-0.0)>1e-6){
                        return result;
                    }
                }
            }
        }
        //默认返回0.0
        return 0.0;

    }

    public static void main(String[] args){
        FrogPosition frogPosition = new FrogPosition();
//        int n = 7;
//        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
//        int t = 2;
//        int target = 4;
//        int n = 3;
//        int[][] edges = {{2,1},{3,2}};
//        int t = 1;
//        int target = 2;
        int n = 4;
        int[][] edges = {{2,1},{3,2},{4,1}};
        int t = 4;
        int target = 1;
        System.out.println(frogPosition.frogPositionDfs(n, edges, t, target));
    }
}
