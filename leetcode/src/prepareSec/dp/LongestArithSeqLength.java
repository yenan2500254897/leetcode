package prepareSec.dp;

import java.util.Arrays;
import java.util.Comparator;

public class LongestArithSeqLength {

    public int longestArithSeqLength(int[] A) {

        int len=A.length;

        //record[i][j]表示从A[0]到A[i]的子数组中等差为j的子序列的长度
        int[][] record = new int[len][20001];

        //初始化record
        for(int i=0;i<len;i++){
            for(int j=0;j<20001;j++){
                record[i][j] = 1;
            }
        }

        for(int i=1;i<len;i++){
            for(int j=i-1;j>=0;j--){
                int diff = A[i]-A[j];

                if(record[j][diff+10000]+1 > record[i][diff+10000]){
                    record[i][diff+10000] = record[j][diff+10000]+1;
                }
            }
        }

        int maxValue = 1;

        for(int i=0;i<len;i++){
            for(int j=0;j<20001;j++){
                if(record[i][j]>maxValue){
                    maxValue = record[i][j];
                }
            }
        }
        return maxValue;
    }
}
