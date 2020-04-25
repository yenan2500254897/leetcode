package prepare;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class TopKFrequentAchieve {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(4);
        for(int item:nums){
            map.put(item, map.getOrDefault(item, 0)+1);
        }

        int len = map.size();
        List<Integer[]> list = new ArrayList<>(len);
        for(Map.Entry entry:map.entrySet()){
            Integer[] assistant = new Integer[2];
            assistant[0] = (Integer)entry.getKey();
            assistant[1] = (Integer)entry.getValue();
            list.add(assistant);
        }

        list.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[1]!=o2[1]){
                    return o2[1].compareTo(o1[1]);
                }
                return o2[0].compareTo(o1[0]);
            }
        });

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = list.get(i)[0];
        }
        return result;
    }
}
