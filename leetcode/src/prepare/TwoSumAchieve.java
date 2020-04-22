package prepare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSumAchieve {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Set<Integer>> record = new HashMap<Integer, Set<Integer>>();
        for(int index=0;index<nums.length;index++){
            if(!record.containsKey(nums[index])){
                Set<Integer> count = new HashSet<Integer>(1);
                count.add(index);
                record.put(nums[index], count);
            }else {
                record.get(nums[index]).add(index);
                record.put(nums[index], record.get(nums[index]));
            }
        }

        Set<Integer> set = record.keySet();
        int[] result = new int[2];
        for(Integer item:set){
            if(target-item != item){
                if(record.containsKey(target-item)){
                    result[0] = (int)record.get(item).toArray()[0];
                    result[1] = (int)record.get(target - item).toArray()[0];
                    break;
                }
            }else {
                if(record.get(item).size() >= 2){
                    result[0] = (int)record.get(item).toArray()[0];
                    result[1] = (int)record.get(item).toArray()[1];
                    break;
                }
            }
        }
        return result;
    }
}
