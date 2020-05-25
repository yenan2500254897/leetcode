package BFS;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class MinJumps {

    public int minJumps(int[] arr) {

        int len = arr.length;

        if(len == 1){
            return 0;
        }

        //map记录arr[i]对应的索引
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>(len);
        for(int i=0;i<len;i++){

            if(!map.containsKey(arr[i])){
                List<Integer> list = new ArrayList<Integer>(1);
                list.add(i);
                map.put(arr[i], list);
            }else {
                List<Integer> already = map.get(arr[i]);
                already.add(i);
                map.put(arr[i], already);
            }
        }

        Queue<Integer> queue = new ArrayDeque<Integer>(4);
        Queue<Integer> assitant = new ArrayDeque<Integer>(4);
        Queue<Integer> already = new ArrayDeque<Integer>(4);
        queue.add(0);

        int step =0;
        while (!queue.isEmpty()){
            Integer currentIndex = queue.poll();
            Integer currentValue = arr[currentIndex];

            if(currentIndex == len -1){
                break;
            }
            //跳到值相等的位置
            List<Integer> indexs = map.get(currentValue);
            for(Integer index: indexs){
                if(!queue.contains(index) && !assitant.contains(index) && !already.contains(index)){
                    assitant.add(index);
                }
            }

            //跳到左右
            int left = currentIndex-1;
            if(left>=0 && !queue.contains(left) && !assitant.contains(left) && !already.contains(left)){
                assitant.add(left);
            }

            int right = currentIndex+1;
            if(right<len && !queue.contains(right) && !assitant.contains(right) && !already.contains(right)){
                assitant.add(right);
            }

            if(queue.isEmpty()){
                step++;
                queue.addAll(assitant);
                already.addAll(assitant);
                assitant.clear();
            }

        }
        return step;
    }

    public static void main(String[] args){
        MinJumps minJumps = new MinJumps();
        //int[] test = {100,-23,-23,404,100,23,23,23,3,404};
        int[] test = {11,22,7,7,7,7,7,7,7,22,13};
        System.out.println(minJumps.minJumps(test));
    }

}
