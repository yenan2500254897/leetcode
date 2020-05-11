package prepareSec.dp;

import utils.TransferToIntegerArray;

import java.io.IOException;

public class KConcatenationMaxSum {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int len = arr.length;

        //record[i]保存到arr[i]为止的最大子数组和
        long[] record = new long[len];
        //index[i]保存到arr[i]为止的最大子数组和的起始索引和终止索引
        int[][] index = new int[len][2];
        //total[i]保存arr[0]到arr[i]的和
        long[] total = new long[len];

        //初始化index
        for(int i=0;i<len;i++){
            for(int j=0;j<index[i].length;j++){
                index[i][j] = -1;
            }
        }

        //初始化record、calTotal
        for(int i =0;i<len;i++){
            if(i==0){
                total[i] = arr[i];
                record[i] = arr[i];
                index[i][0] = 0;
                index[i][1] = 0;
                continue;
            }
            total[i] = total[i-1]+arr[i];
            if(record[i-1]+arr[i]>=arr[i]){
                record[i] = record[i-1]+arr[i];
                index[i][0] = index[i-1][0];
                index[i][1] = i;
            }else {
                record[i] = arr[i];
                index[i][0] = i;
                index[i][1] = i;
            }
        }

        //保存最大子数组和
        long maxValue = 0;
        //保存最大子数组和的截止索引
        int maxIndex =-1;

        for(int i=0;i<len;i++){
            if(record[i]>=maxValue){
                maxValue = record[i];
                maxIndex = i;
            }
        }

        //最大子数组和为负数
        if(maxValue == 0){
            return (int)(maxValue%1000000007);
        }

        int leftIndex = index[maxIndex][0]-1;
        int rightIndex = index[maxIndex][1]+1;
        if(leftIndex == -1 && rightIndex==len){
            return (int)(k*total[len-1]%1000000007);
        }

        long pre = 0;
        long post = rightIndex <= len-1?record[len-1]:0;



        for(int i=0;i<=maxIndex;i++){
            pre = Math.max(pre, total[i]);
        }

        long result = maxValue;
        if(maxIndex == len-1){
            result = Math.max(maxValue+pre, maxValue+(k-1)*total[len-1]);
        }else {
            result = Math.max(maxValue, Math.max(pre+post, maxValue + (k-1)*total[len-1]));
        }

        return (int)(result%1000000007);

    }




    public static void main(String[] args) throws IOException {
        KConcatenationMaxSum kConcatenationMaxSum = new KConcatenationMaxSum();
        TransferToIntegerArray transferToIntegerArray = new TransferToIntegerArray();
        int[] test = transferToIntegerArray.toOneDimArray();

        System.out.println(kConcatenationMaxSum.kConcatenationMaxSum(test,5263));
    }
}
