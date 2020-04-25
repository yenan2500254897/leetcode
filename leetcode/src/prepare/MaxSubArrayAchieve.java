package prepare;

import java.util.Arrays;

public class MaxSubArrayAchieve {

    public int maxSubArray(int[] nums) {

        int len = nums.length;
        if(len == 0){
            return 0;
        }

        int[] record = new int[len];
        record[0] = nums[0];
        for(int i=1;i<len;i++){
            record[i] = Math.max(nums[i], record[i-1]+nums[i]);
        }
        Arrays.sort(record);
        return record[len-1];
    }
}
