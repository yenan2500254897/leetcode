package middle.DFS;

import java.util.*;

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
