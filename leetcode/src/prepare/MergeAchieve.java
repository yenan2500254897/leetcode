package prepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeAchieve {

    public int[][] merge(int[][] intervals) {

        List<int[]> list = Arrays.asList(intervals);

        //先按照左节点排序，后按照右节点排序
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer l0 = o1[0];
                Integer l1 = o1[1];
                Integer r0 = o2[0];
                Integer r1 = o2[1];
                if(l0!=r0){
                    return l0.compareTo(r0);
                }
                return l1.compareTo(r1);
            }
        });

        int len = intervals.length;
        List<int[]> result = new ArrayList<>(len);
        int current = 0;
        for(int next = 1;next<len;next++){
            //两个区间无重叠
            if(list.get(current)[1]<list.get(next)[0]){
                result.add(list.get(current));
                current++;
                continue;
            }

            //两个区间有重叠
            int[] temp = list.get(current);

            while (next<len && !(temp[1]<list.get(next)[0])){
                int[] secondArray = list.get(next);
                temp[0] = Math.min(temp[0], secondArray[0]);
                temp[1] = Math.max(temp[1], secondArray[1]);
                next++;
            }
            result.add(temp);
            current = next;
        }

        if(current == len-1){
            result.add(list.get(current));
        }
        return result.toArray(new int[0][]);
    }
}
