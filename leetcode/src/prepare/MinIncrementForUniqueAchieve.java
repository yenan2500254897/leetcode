package prepare;

import java.util.*;

public class MinIncrementForUniqueAchieve {

//    public int minIncrementForUnique(int[] A) {
//
//        Set<Integer> set = new HashSet<>(4);
//        List<Integer> list = new ArrayList<>(4);
//
//        for(int item:A){
//            if(!set.contains(item)){
//                set.add(item);
//            }else {
//                list.add(item);
//            }
//        }
//
//        int count =0;
//        while (!list.isEmpty()){
//            int head = list.get(0);
//            head+=1;
//            count++;
//            if(!set.contains(head)){
//                list.remove(0);
//                set.add(head);
//            }else {
//                list.set(0,head);
//            }
//        }
//        return count;
//    }

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);

        int[] record = new int[80001];

        Queue<Integer> queue = new ArrayDeque<>(4);
        for(int item:A){
            if(record[item] == 0){
                record[item] = 1;
            }else {
                queue.add(item);
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            int head = queue.poll();
            int index = findFirstZero(record, head+1);
            count += (index-head);
            record[index] = 1;
        }
        return count;
    }

    private int findFirstZero(int[] array, int start){
        int index = start;
        while (index<array.length){
            if(array[index]==0){
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] test = new int[]{3,2,1,2,1,7};
        MinIncrementForUniqueAchieve item = new MinIncrementForUniqueAchieve();
        System.out.println(item.minIncrementForUnique(test));
    }

}
