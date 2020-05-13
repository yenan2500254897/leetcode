package prepareSec.dp;

import java.util.Arrays;
import java.util.Comparator;

public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return len;
        }

        //record[i][0]表示从nums[0]到nums[i]的最长递增子序列长度,
        //record[i][1]表示从nums[0]到nums[i]的最长递增子序列的个数
        int[][] record = new int[len][2];

        for(int i=0;i<len;i++){
            record[i][0] = 1;
            record[i][1] = 1;
        }

        for(int i=0;i<len;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    if(record[j][0] + 1 >record[i][0]){
                        record[i][0] = record[j][0] + 1;
                        record[i][1] = record[j][1];
                    }else if(record[j][0] + 1 == record[i][0]){
                        record[i][1] += record[j][1];
                    }else {

                    }


                }
            }
        }

        Arrays.sort(record, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o2[0]>o1[0]?1: o2[0]==o1[0]?0:-1;

            }
        });

        int value = record[0][0];
        int result = record[0][1];
        for(int i=1;i<len;i++){
            if(record[i][0]!=value){
                break;
            }
            result+=record[i][1];
        }
        return result;
    }

    public static void main(String[] args){
        FindNumberOfLIS findNumberOfLIS = new FindNumberOfLIS();
        int[] test ={4,3,2,0,3,1,10,2,1,1,9,5,9,6,8,6,5,1,0,10,8,6,-9,0,8,9,5,0,2,2,4,0,9,10,2,0,0,7,10,9,6,0,8,9,10,7,8,8,3,9,5,3,4,6,1,5,4,7,9,2,5,10,4,-3,4,6,4,6,1,1,10,0,9,9,3,5,1,3,3,2,1,3,8,7,1,2,0,7,4};
        System.out.println(findNumberOfLIS.findNumberOfLIS(test));
    }
}
