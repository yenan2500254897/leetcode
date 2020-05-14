package prepareSec.dp;

public class FindTargetSumWays {
//    public int findTargetSumWays(int[] nums, int S) {
//        int len = nums.length;
//        int result =0;
//        for(int i=0;i<1<<len;i++){
//            if(cal(i, nums) == S){
//                result++;
//            }
//        }
//        return result;
//    }
//
//    private int cal(int input, int[] nums){
//        int len = nums.length;
//        int result = 0;
//        for(int i=0;i<len;i++){
//            if((input & (1<<i)) != 0){
//                result += nums[i];
//            }else {
//                result -= nums[i];
//            }
//        }
//        return result;
//    }

    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        int[] dp = new int[2001];
        for(int i=0;i<len;i++){
            int[] dp2 = new int[2001];
            for(int j=0;j<2001;j++){
                if(i == 0){
                    dp2[nums[i]+1000] += 1;
                    dp2[1000 - nums[i]] += 1;
                    break;
                }

                if(dp[j]!=0){
                    dp2[j+nums[i]] += dp[j];
                    dp2[j-nums[i]] += dp[j];
                }
            }
            dp = dp2;
        }


        return (S+1000>=0 && S+1000<2001)?dp[S+1000]:0;
    }

    public static void main(String[] args){
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        int[] test = {0,1};
        System.out.println(findTargetSumWays.findTargetSumWays(test, 1));
    }
}
