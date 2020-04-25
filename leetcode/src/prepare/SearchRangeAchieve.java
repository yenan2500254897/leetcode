package prepare;

public class SearchRangeAchieve {

    public int[] searchRange(int[] nums, int target) {

        return search(nums, 0, nums.length-1, target);
    }

    public int[] search(int[] nums,int start, int end, int target){
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(start<end){
            return result;
        }

        if(start == end){
            if(target == nums[start]){
                result[0] = start;
                result[1] = end;
            }
            return result;
        }

        int[] left = search(nums, start, (start+end)/2, target);
        int[] right = search(nums, (start+end)/2+1, end, target);

        if(left[1]!=-1 && right[0]!=-1){
            result[0] = left[0];
            result[1] = right[1];
        }else {
            if(left[1] == -1){
                return right;
            }
            return left;
        }
        return result;
    }
}
