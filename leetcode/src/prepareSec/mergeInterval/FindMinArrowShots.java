package prepareSec.mergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {

        if(points.length == 0){
            return 0;
        }

        int len = points.length;

        List<int[]> list = Arrays.asList(points);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]<o2[0]?-1:1;
                }
                return o1[1]<o2[1]?-1:1;
            }
        });

        //record[i]表示到i需要最少的箭
        int[] record = new int[len];
        List<int[]> preList= new ArrayList<int[]>(len);

        record[0] = 1;
        preList.add(list.get(0));
        for(int index = 1;index<len;index++){

            //区间不重叠
            if(preList.get(index-1)[1]<=list.get(index)[0]){
                record[index] = record[index-1]+1;
                preList.add(list.get(index));
            }else {
                //区间重叠
                record[index] = record[index-1];
                int[] temp = new int[2];
                temp[0] = Math.max(preList.get(index-1)[0], list.get(index)[0]);
                temp[1] = Math.min(preList.get(index-1)[1], list.get(index)[1]);
                preList.add(temp);
            }
        }
        return record[len-1];
    }


    public static void main(String[] args){
        int[][] points = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        int result = findMinArrowShots.findMinArrowShots(points);
        System.out.println(result);
    }
}
