package prepareSec.dp;

import utils.TransferToIntegerArray;

import java.io.IOException;

public class KConcatenationMaxSum {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int len = arr.length;

        //calTotal[i]保存到arr[i]为止的最大子数组和
        long[] calTotal = new long[len];
        //record[i]计算arr[0]到arr[i]d的和
        long[] record = new long[len];

        //初始化record、calTotal
        for(int i =0;i<len;i++){
            if(i==0){
                calTotal[i] = arr[i];
                record[i] = arr[i];
                continue;
            }
            record[i] = record[i-1]+arr[i];
            calTotal[i]= Math.max(calTotal[i-1]+arr[i], arr[i]);
        }

        //保存最大子数组和
        long maxValue = 0;
        //保存最大子数组和的截止索引
        int maxIndex =-1;
        //判断子数组和的截止索引为len-1时，中间是否有中断
        boolean flag = false;

        for(int i=0;i<len;i++){
            if(calTotal[i]>=maxValue){
                maxValue = calTotal[i];
                maxIndex = i;
            }else {
                flag = true;
            }
        }


        //最大子数组和为负数
        if(maxValue == 0){
            return (int)(maxValue%1000000007);
        }

        //最大子数组和的截止索引为len-1
        if(maxIndex == len-1 && flag == false){
            //最大子数组和未被打断
            return (int)(k*maxValue%1000000007);
        }

        //最大子数组和被打断或最大子数组的截止索引不为len-1
        int gapIndex = maxIndex;
        for(;gapIndex>=0;gapIndex--){
            if(calTotal[gapIndex]<0){
                break;
            }
        }

        long pre = 0;
        long post = maxIndex == len-1?0:calTotal[len-1];

        for(int i=0;i<=maxIndex;i++){
            pre = Math.max(pre, record[i]);
        }

        long result = maxValue;
        if(maxIndex == len-1){
            result = Math.max(maxValue+pre, maxValue+(k-1)*record[len-1]);
        }else {
            result = Math.max(maxValue, Math.max(pre+post, maxValue + (k-1)*record[len-1]));
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
