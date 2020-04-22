package prepare;

import java.util.*;

public class ThreeSumAchieve {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        //用set防止重复
        Set<List<Integer>> set = new HashSet<>(4);

        //每次先确定中间元素
        for(int index = 1;index<nums.length-1;index++){
            int start = 0;
            int end = nums.length-1;

            while (start<index && index<end){
                int total = nums[start] + nums[index] + nums[end];
                //恰好等于零
                if(total == 0){
                    List<Integer> assistant = new ArrayList<>(3);
                    assistant.add(nums[start]);
                    assistant.add(nums[index]);
                    assistant.add(nums[end]);
                    set.add(assistant);

                    //当选取index对应的值为中间值时，左右两边可能存在多个值使三数之和为0
                    start++;
                    end--;
                }else if(total>0){
                    //和大于0，调整右边
                    end--;
                }else {
                    //和小于0，调整左边
                    start++;
                }
            }
        }

        List<List<Integer>> lists = new ArrayList<>(set.size());
        lists.addAll(set);
        return lists;

    }
}
