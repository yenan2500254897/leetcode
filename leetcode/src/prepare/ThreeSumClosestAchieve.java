package prepare;

import java.util.Arrays;

public class ThreeSumClosestAchieve {
    //-3 -1 1 3
    public int threeSumClosest(int[] nums, int target) {

        //排序
        Arrays.sort(nums);
        int len = nums.length;
        Integer result = Integer.MAX_VALUE;
        for(int index = 1;index<len-1;index++){

            int start = index-1;
            int end = index+1;
            int preTotal = nums[start]+nums[index]+nums[end];

            while (start>=0 && end<len){
                //等于则跳出内层循环
                if(preTotal==target){
                    break;
                }else if(preTotal > target){
                    //三者之和大于target，则向左移动左边的数
                    start--;
                    if(start>=0){
                        int currentTotal = nums[start]+nums[index]+nums[end];
                        preTotal = Math.abs(currentTotal-target)<Math.abs(preTotal-target)?currentTotal:preTotal;
                    }
                }else{
                    //三者之和小于target，则向右移动右边的数
                    end++;
                    if(end<len){
                        int currentTotal = nums[start]+nums[index]+nums[end];
                        preTotal = Math.abs(currentTotal-target)<Math.abs(preTotal-target)?currentTotal:preTotal;
                    }
                }
            }

            if(preTotal == target){
                result = preTotal;
                break;
            }

            if(result == Integer.MAX_VALUE){
                result = preTotal;
            }else {
                result = Math.abs(result-target)<=Math.abs(preTotal-target)?result : preTotal;
            }

        }
        return result;
    }


}
