package middle.DynamicProgramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 *
 */
public class maxSumDivThree {
//    public int result = 0;
//    public int maxSumDivThree(int[] nums) {
//        calValue(0, nums, 0);
//        return result;
//
//    }
//
//    public void calValue(int currentTotal, int[] num, int index){
//        if(index>=num.length){
//            return ;
//        }
//        if((currentTotal + num[index]) % 3 == 0 && (currentTotal + num[index])>result){
//            result = currentTotal + num[index];
//        }
//        calValue(currentTotal, num, index+1);
//        calValue(currentTotal+num[index], num, index+1);
//    }

    public int maxSumDivThree(int[] nums){
        int result = 0;
        List<Integer> remindOne = new ArrayList<>();
        List<Integer> remindTwo = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            result+=nums[i];
            int temp=nums[i]%3;
            if(temp == 1){
                remindOne.add(nums[i]);
            }
            if(temp == 2){
                remindTwo.add(nums[i]);
            }
        }
        remindOne.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        remindTwo.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        if(result%3==0){
            return result;
        }
        int tempValue=0;
        if(result%3==1){
            if(!remindOne.isEmpty()){
                tempValue = Math.max(tempValue, result- remindOne.get(0));
            }
            if(remindTwo.size()>=2){
                tempValue = Math.max(tempValue, result- remindTwo.get(0)-remindTwo.get(1));
            }
        }
        if(result%3==2){
            if(!remindTwo.isEmpty()){
                tempValue = Math.max(tempValue, result- remindTwo.get(0));
            }
            if(remindOne.size()>=2){
                tempValue = Math.max(tempValue, result- remindOne.get(0)-remindOne.get(1));
            }
        }
        return tempValue;
    }

}
