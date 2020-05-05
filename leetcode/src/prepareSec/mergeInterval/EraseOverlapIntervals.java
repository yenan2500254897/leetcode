package prepareSec.mergeInterval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EraseOverlapIntervals {

    //暴力法
//    private int minValue = Integer.MAX_VALUE;
//    public int eraseOverlapIntervals(int[][] intervals) {
//
//        List<int[]> list = Arrays.asList(intervals);
//        list.sort(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] != o2[0]){
//                    return o1[0] < o2[0]?-1:1;
//                }
//                return o1[1] < o2[1]?-1:1;
//            }
//        });
//
//        remove(list, -1,0,0);
//        return minValue;
//
//    }
//
//    private void remove(List<int[]> list, int pre, int current, int removeCount){
//        //终止条件
//        if(current == list.size()){
//            minValue = Math.min(minValue, removeCount);
//            return;
//        }
//
//
//        //区间未重复
//        if(pre == -1 || list.get(pre)[1]<=list.get(current)[0]){
//            remove(list, current, current+1, removeCount);
//        }
//
//        remove(list, pre, current+1, removeCount+1);
//    }

    //动态规划
//    public int eraseOverlapIntervals(int[][] intervals){
//
//        if(intervals.length == 0){
//            return 0;
//        }
//
//        List<int[]> list = Arrays.asList(intervals);
//        list.sort(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] != o2[0]){
//                    return o1[0] < o2[0]?-1:1;
//                }
//                return o1[1] < o2[1]?-1:1;
//            }
//        });
//
//        int len = list.size();
//        //record[i] 记录intervals中到intervals[i]的最大不重叠区间书
//        int[] record = new int[len];
//
//        int index = 0;
//
//        while (index<len){
//            if(index == 0){
//                record[index] = 1;
//                index++;
//                continue;
//            }
//
//            for(int inner=0;inner<index;inner++){
//                if(list.get(inner)[1]<=list.get(index)[0]){
//                    record[index] = Math.max(record[index], record[inner]+1);
//                }
//            }
//            if(record[index] == 0){
//                record[index] = 1;
//            }
//            index++;
//        }
//
//        return len - record[len-1];
//    }

    //贪心算法
    public int eraseOverlapIntervals(int[][] intervals){
        if(intervals.length == 0){
            return 0;
        }

        List<int[]> list = Arrays.asList(intervals);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] < o2[0]?-1:1;
                }
                return o1[1] < o2[1]?-1:1;
            }
        });

        int count = 0;
        int len = list.size();
        int pre = -1;
        int current = 0;
        while (current<len){
            if(current == 0){
                pre = current;
                current = current+1;
                continue;
            }

            if(list.get(pre)[1]<=list.get(current)[0]){
                pre = current;
                current = current+1;
            }else {
                if(list.get(pre)[1]>=list.get(current)[1]){
                    count++;
                    pre = current;
                    current = current+1;
                }else {
                    current = current+1;
                }
                count++;
            }

        }
        return count;
    }
}
