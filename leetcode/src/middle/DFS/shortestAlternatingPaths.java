package middle.DFS;

import java.util.*;

/**
 * 1129. 颜色交替的最短路径
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。
 *
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
 *
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的最短路径的长度，且路径上红色边和蓝色边交替出现。如果不存在这样的路径，那么 answer[x] = -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * 示例 2：
 *
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * 示例 3：
 *
 * 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * 输出：[0,-1,-1]
 * 示例 4：
 *
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * 输出：[0,1,2]
 * 示例 5：
 *
 * 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * 输出：[0,1,1]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 *
 */
public class shortestAlternatingPaths {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        if(n==1){
            return new int[1];
        }

        Map<Integer, List<Integer>> redMap = transfer(red_edges);
        Map<Integer, List<Integer>> blueMap = transfer(blue_edges);

        int cur = 0;
        List<Integer> redTemp = redMap.get(cur);
        List<Integer> blueTemp = blueMap.get(cur);
        int[] redDistance = deal(blueTemp, n);
        int[] blueDistance = deal(redTemp, n);
        Queue<Integer> open = new ArrayDeque<>();
        if(redTemp !=null){
            for(Integer item: redTemp){
                open.add(item);
            }
        }

        if(blueTemp != null){
            for(Integer item: blueTemp){
                open.add(item);
            }
        }

        while(!open.isEmpty()){
            int curVal = open.poll();
            redTemp = redMap.get(curVal);
            if(redTemp != null){
                for(Integer item : redTemp){
                    if(item == 0){
                        continue;
                    }
                    int value = blueDistance[item];
                    if(redDistance[curVal] != 0){
                        if(value == 0){
                            blueDistance[item] = redDistance[curVal] + 1;
                        }else {
                            blueDistance[item] = Math.min(value, redDistance[curVal]+1);
                        }
                    }
                    if(value != blueDistance[item]){
                        open.add(item);
                    }
                }
            }

            blueTemp = blueMap.get(curVal);
            if(blueTemp != null){
                for(Integer item : blueTemp){
                    if(item == 0){
                        continue;
                    }
                    int value = redDistance[item];
                    if(blueDistance[curVal] != 0){
                        if(value == 0){
                            redDistance[item] = blueDistance[curVal] + 1;
                        }else {
                            redDistance[item] = Math.min(value, blueDistance[curVal]+1);
                        }
                    }
                    if(value != redDistance[item]){
                        open.add(item);
                    }
                }
            }
        }
        int[] result=new int[n];
        for(int i=1;i<n;i++){
            if(redDistance[i] == 0 && blueDistance[i] == 0){
                result[i] = -1;
            } else if(redDistance[i] == 0 || blueDistance[i] == 0){
                result[i] = redDistance[i] + blueDistance[i];
            }else{
                result[i] = Math.min(redDistance[i], blueDistance[i]);
            }
        }
        return result;

    }

    private Map<Integer, List<Integer>> transfer(int[][] input){
        Map<Integer, List<Integer>> result = new HashMap<>();
        for(int[] item:input){
            if(!result.containsKey(item[0])){
                List<Integer> list = new ArrayList<>();
                list.add(item[1]);
                result.put(item[0], list);
            }else {
                List<Integer> list = result.get(item[0]);
                list.add(item[1]);
                result.put(item[0], list);
            }
        }
        return result;
    }

    private int[] deal(List<Integer> list,int n){
        int[] array = new int[n];

        if(list !=null &&!list.isEmpty()){
            for(Integer item:list){
                array[item] = item == 0 ? 0:1;
            }
        }
        return array;
    }
}
