package minimization;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class PredictTheWinner {

    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        if(len <= 2){
            return true;
        }
        int total = 0;
        for(int i=0;i<len;i++){
            total+=nums[i];
        }
        int first = find(nums, 0, len-1);
        return first>=total-first?true:false;
    }

    public int find(int[] nums, int left, int right){
        if(left>right){
            return 0;
        }
        if(left == right){
            return nums[left];
        }

        int leftValue = nums[left];
        int rightValue = nums[right];

        int leftSecondValue = Math.min(find(nums, left+1, right-1), find(nums,left+2, right));
        int rightSecondValue = Math.min(find(nums,left+1, right-1), find(nums, left, right-2));
        return Math.max(leftValue + leftSecondValue, rightValue+rightSecondValue);

    }

    public static void main(String[] args){
        PredictTheWinner predictTheWinner = new PredictTheWinner();
        int[] test = {1, 5, 2};
        System.out.println(predictTheWinner.PredictTheWinner(test));
    }


}
