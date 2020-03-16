package JZOffer;

import com.sun.org.apache.xerces.internal.xni.parser.XMLErrorHandler;

import java.util.Arrays;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if(len<=1){
            return 0;
        }

        int midPoint = len/2;
        int[] left = Arrays.copyOfRange(nums,0,midPoint);
        int[] right = Arrays.copyOfRange(nums, midPoint, len);
        int tempResult = reversePairs(left) + reversePairs(right);
        Arrays.sort(left);
        Arrays.sort(right);
        return  tempResult+ merge(left,right);
    }

    public int merge(int[] left, int[] right){
        int lIndex=0;
        int rIndex=0;
        int result = 0;
        while (lIndex<left.length && rIndex<right.length){
            if(left[lIndex]<=right[rIndex]){
                lIndex++;
                continue;
            }
            while (lIndex<left.length && rIndex<right.length && left[lIndex]>right[rIndex]){
                result+=left.length-lIndex;
                rIndex++;
            }
        }
        return result;
    }
}
