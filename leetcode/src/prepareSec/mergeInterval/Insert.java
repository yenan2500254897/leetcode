package prepareSec.mergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }

        int len = intervals.length;

        boolean left = true;
        boolean right = true;
        List<int[]> list = new ArrayList<>(4);
        int[] temp = new int[2];
        temp[0] = Integer.MAX_VALUE;
        temp[1] = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){

            //第一次碰到区间重叠前
            if(left && right){
                if(intervals[i][1]<newInterval[0]){
                    list.add(intervals[i]);
                }else {
                    left = false;
                }
            }

            //第一次碰到区间重叠
            if (!left && right) {
                if(newInterval[1]<intervals[i][0]){
                    right =false;
                    list.add(temp);
                }else {
                    temp[0] = Math.min(temp[0], Math.min(newInterval[0], intervals[i][0]));
                    temp[1] = Math.max(temp[1], Math.max(newInterval[1], intervals[i][1]));
                }

            }

            //区间重叠结束
            if(!left && !right){
                list.add(intervals[i]);
            }
        }

        //无区间重叠
        if(left && right){
            list.add(newInterval);
        }
        //无区间重叠结束
        if(!left && right){
            list.add(temp);
        }

        int finalLen = list.size();
        int[][] result = new int[finalLen][2];
        for(int i=0;i<finalLen;i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args){
        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = new int[]{4,8};
        Insert insert = new Insert();
        insert.insert(intervals, newInterval);
    }
}
