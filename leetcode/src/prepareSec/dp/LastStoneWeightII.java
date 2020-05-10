package prepareSec.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LastStoneWeightII {

    //0-1背包问题
    public int lastStoneWeightII(int[] stones) {

        int len = stones.length;

        int sum = 0;
        for(int i=0;i<len;i++){
            sum += stones[i];
        }

        int[] record = new int[100000];
        record[0] = 1;
        //代表stones中的第i个
        for(int row = 0;row<len;row++){
            //表示剩余可装的石头重量
            for(int col = sum/2;col>=0;col--){

                if(record[col]>0 && (col + stones[row]<=sum/2)){
                   record[col + stones[row]] = 1;
                }
            }
        }

        for(int i=sum/2;i>=0;i--){
            if(record[i]>0){
                return sum -2*i;
            }
        }
        return 0;

    }
    public static void main(String[] args){
        LastStoneWeightII lastStoneWeightII = new LastStoneWeightII();
        int[] test = {6,2,2,6,5,7,7};
        System.out.println(lastStoneWeightII.lastStoneWeightII(test));
    }
}
