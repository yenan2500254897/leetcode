package prepareSec.dp;

import utils.TransferToIntegerArray;

import java.io.IOException;
import java.util.Arrays;

public class MaximumSum {

    //前缀和与后缀和
    public int maximumSum(int[] arr) {

        int len = arr.length;
        if(len == 1){
            return arr[0];
        }

        int[] prefix = new int[len];
        int[] suffix = new int[len];

        for(int i=0;i<len;i++){
            if(i==0){
                prefix[i] = arr[i];
                suffix[len-i-1] = arr[len-i-1];
                continue;
            }
            prefix[i] = Math.max(prefix[i-1]+arr[i], arr[i]);
            suffix[len-i-1] = Math.max(suffix[len-i] + arr[len-i-1], arr[len-i-1]);
        }


        int result = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            if(arr[i]<0){
                int left = i==0?0:prefix[i-1];
                int right = i==len-1?0:suffix[i+1];
                result = Math.max(result, left+right);
            }
        }

        Arrays.sort(prefix);
        result = Math.max(prefix[len-1], result);


        return result;
    }

    public static void main(String[] args) throws IOException {
        TransferToIntegerArray transferToIntegerArray = new TransferToIntegerArray();
        int[] test = transferToIntegerArray.toOneDimArray();
        MaximumSum maximumSum = new MaximumSum();
        System.out.println(maximumSum.maximumSum(test));
    }
}
