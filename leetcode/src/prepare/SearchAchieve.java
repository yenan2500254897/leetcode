package prepare;

import java.util.Arrays;

public class SearchAchieve {

    public int search(int[] nums, int target) {
        return find(nums, 0, nums.length-1, target);
    }

    public int find(int[] nums,int start, int end, int target){
        if(start>end){
            return -1;
        }

        if(start == end){
            if(target == nums[start]){
                return start;
            }
            return -1;
        }

        int mid = (start+end)/2;
        int left = find(nums, start, mid, target);
        int right = find(nums, mid+1, end, target);

        if(left!=-1){
            return left;
        }
        return right;
    }


}
