package DFS;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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

    public static void main(String[] args){
        FrogPosition frogPosition = new FrogPosition();
//        int n = 7;
//        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
//        int t = 2;
//        int target = 4;
        int n = 3;
        int[][] edges = {{2,1},{3,2}};
        int t = 1;
        int target = 2;
//        int n = 4;
//        int[][] edges = {{2,1},{3,2},{4,1}};
//        int t = 4;
//        int target = 1;
        System.out.println(frogPosition.frogPosition(n, edges, t, target));
    }
}
