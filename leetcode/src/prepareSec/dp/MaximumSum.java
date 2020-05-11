package prepareSec.dp;

import utils.TransferToIntegerArray;

import java.io.IOException;
import java.util.Arrays;

public class MaximumSum {

    public int maximumSum(int[] arr) {

        int len = arr.length;
        if(len == 1){
            return arr[0];
        }

        int[] noDelRecord = new int[len];
        int[] hasDelRecord = new int[len];

        for(int i=0;i<len;i++){
            if(i==0){
                noDelRecord[i] = arr[i];
                continue;
            }
            noDelRecord[i] = Math.max(noDelRecord[i-1]+arr[i], arr[i]);
        }


        int[] copyOfNoDelRecord = Arrays.copyOfRange(noDelRecord, 0, len);
        Arrays.sort(copyOfNoDelRecord);
        int result = copyOfNoDelRecord[len-1];
        if(copyOfNoDelRecord[0] == copyOfNoDelRecord[len-1]){
            return result;
        }

        for(int i=0;i<len;i++){

            for(int j=0;j<len;j++){
                if(j<i){
                    hasDelRecord[j] = noDelRecord[j];
                }else if(i==j){
                    hasDelRecord[j] = noDelRecord[j] - arr[j];
                }else {
                    hasDelRecord[j] = Math.max(hasDelRecord[j-1]+arr[j], arr[j]);
                }
            }
            Arrays.sort(hasDelRecord);
            result = Math.max(result, hasDelRecord[len-1]);
        }


        return result;
    }

    public static void main(String[] args) throws IOException {
        TransferToIntegerArray transferToIntegerArray = new TransferToIntegerArray();
        int[] test = transferToIntegerArray.toOneDimArray();
        MaximumSum maximumSum = new MaximumSum();
        System.out.println(maximumSum.maximumSum(test));
    }
}
