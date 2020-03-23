package JZOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 面试题03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 */
public class findRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = -1;
        for(int item:nums){
            if(!map.keySet().contains(item)){
                map.put(item, 1);
            }else {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * 思路：如果无重复，则坐标为i的位置上，值也为i
     * @param nums
     * @return
     */
    public int secFindRepeatNumber(int[] nums) {
        int length = nums.length;
        for(int i=0;i<length;i++){
            int item = nums[i];
            while(i != item){
                int temp = nums[item];
                if(temp == item){
                    return item;
                }
                nums[item] = item;
                nums[i] = temp;
                item = nums[i];
            }
        }
        return -1;
    }

}
