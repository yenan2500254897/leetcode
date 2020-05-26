package BFS;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class MinJumps {

    //用队列模拟bfs会超时
    //TODO:改用数组记录状态试一下
//    public int minJumps(int[] arr) {
//
//        int len = arr.length;
//
//        if(len == 1){
//            return 0;
//        }
//
//        //map记录arr[i]对应的索引
//        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>(len);
//        for(int i=0;i<len;i++){
//
//            if(!map.containsKey(arr[i])){
//                List<Integer> list = new ArrayList<Integer>(1);
//                list.add(i);
//                map.put(arr[i], list);
//            }else {
//                List<Integer> already = map.get(arr[i]);
//                already.add(i);
//                map.put(arr[i], already);
//            }
//        }
//
//        Queue<Integer> queue = new ArrayDeque<Integer>(4);
//        Queue<Integer> assitant = new ArrayDeque<Integer>(4);
//        Queue<Integer> already = new ArrayDeque<Integer>(4);
//        queue.add(0);
//
//        int step =0;
//        while (!queue.isEmpty()){
//            Integer currentIndex = queue.poll();
//            Integer currentValue = arr[currentIndex];
//
//            if(currentIndex == len -1){
//                break;
//            }
//            //跳到值相等的位置
//            List<Integer> indexs = map.get(currentValue);
//            Integer index = 0;
//            for(int i=indexs.size()-1;i>=0;i--){
//                index = indexs.get(i);
//                if(!queue.contains(index) && !assitant.contains(index) && !already.contains(index)){
//                    assitant.add(index);
//                }
//            }
//
//            //跳到左右
//            int left = currentIndex-1;
//            if(left>=0 && !queue.contains(left) && !assitant.contains(left) && !already.contains(left)){
//                assitant.add(left);
//            }
//
//            int right = currentIndex+1;
//            if(right<len && !queue.contains(right) && !assitant.contains(right) && !already.contains(right)){
//                assitant.add(right);
//            }
//
//            if(queue.isEmpty()){
//                step++;
//                queue.addAll(assitant);
//                already.addAll(assitant);
//                assitant.clear();
//            }
//
//        }
//        return step;
//    }


    //超时解决方案：
    //原因：多次遍历之前已经遍历过的值对应的索引，测试用例为{7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,1,2}
    //解决方案：遍历完一种值之后，把该值作为key的key-value 删掉
    public int minJumps(int[] arr) {

        int len = arr.length;

        if(len == 1){
            return 0;
        }

        if(arr[0] == arr[len-1]){
            return 1;
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
        //记录当前位置是否被访问过
        boolean[] visited = new boolean[len];

        Queue<Integer> queue = new ArrayDeque<Integer>(4);
        Queue<Integer> assitant = new ArrayDeque<Integer>(4);
        queue.add(0);
        visited[0] = true;

        int step =0;
        while (!queue.isEmpty()){
            Integer currentIndex = queue.poll();
            Integer currentValue = arr[currentIndex];
//            System.out.println("currentIndex: " + currentIndex + " currentValue: " + currentValue);
            if(currentIndex == len -1){
                break;
            }

            //map中的键不包含该值,则跳过，保证同值的索引只遍历一次
            if(map.containsKey(currentValue)){
                //跳到值相等的位置
                List<Integer> indexs = map.get(currentValue);
                Integer index = 0;
                for(int i=indexs.size()-1;i>=0;i--){
                    index = indexs.get(i);
                    if(visited[index] == false){
                        assitant.add(index);
                        visited[index] = true;
                    }
                }
                map.remove(currentValue);
            }

            //跳到左右
            int left = currentIndex-1;
            if(left>=0 && visited[left] == false){
                assitant.add(left);
                visited[left] = true;
            }

            int right = currentIndex+1;
            if(right<len && visited[right] == false){
                assitant.add(right);
                visited[right] = true;
            }

            if(queue.isEmpty()){
                step++;
//                System.out.println("step = " + step + " ");
                queue.addAll(assitant);
                assitant.clear();
            }

        }
        return step;
    }
    public static void main(String[] args){
        MinJumps minJumps = new MinJumps();
        //int[] test = {100,-23,-23,404,100,23,23,23,3,404};
        //int[] test = {11,22,7,7,7,7,7,7,7,22,13};
        //int[] test = {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,1,2};
        int[] test = {68,-94,-44,-18,-1,18,-87,29,-6,-87,-27,37,-57,7,18,68,-59,29,7,53,-27,-59,18,-1,18,-18,-59,-1,-18,-84,-20,7,7,-87,-18,-84,-20,-27};
        //int[] test = {7,1};
        System.out.println(minJumps.minJumps(test));
    }

}
