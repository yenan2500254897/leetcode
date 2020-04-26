package prepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthOfLISAchieve {

//    private int maxValue = 0;
//
//    public int lengthOfLIS(int[] nums) {
//
//        int len = nums.length;
//        if(len<=1){
//            return len;
//        }
//
//        List<Integer> list = new ArrayList<>(4);
//        find(nums, 0, list);
//        return maxValue;
//    }
//
//    public void find(int[] nums, int index, List<Integer> record){
//        int len = nums.length;
//        if(index == len){
//            return;
//        }
//
//        if(record.isEmpty() || nums[index]>record.get(record.size()-1)){
//            record.add(nums[index]);
//            maxValue = Math.max(maxValue, record.size());
//            find(nums, index+1, record);
//            record.remove(record.size()-1);
//        }
//
//        find(nums, index+1, record);
//    }

    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if(len<=1){
            return len;
        }

        int[] record = new int[len];
        for(int i=0;i<len;i++){
            record[i] = 1;
        }

        for(int outter = 1;outter<len;outter++){
            for (int inner=0;inner<outter; inner++) {
                if(nums[inner]<nums[outter]){
                    record[outter] = Math.max(record[outter], record[inner]+1);
                }
            }
        }

        Arrays.sort(record);
        return record[len-1];
    }

    public static void main(String[] args){
        LengthOfLISAchieve item = new LengthOfLISAchieve();
        int[] test = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(item.lengthOfLIS(test));
    }
}
