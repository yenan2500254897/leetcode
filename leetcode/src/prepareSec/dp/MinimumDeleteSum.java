package prepareSec.dp;

public class MinimumDeleteSum {

    public int minimumDeleteSum(String s1, String s2) {
        int len1= s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }

        for(int i=1;i<=len2;i++){
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){

                dp[i][j] = Math.min(dp[i-1][j]+ s1.charAt(i-1), dp[i][j-1]+s2.charAt(j-1));
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args){
        MinimumDeleteSum minimumDeleteSum = new MinimumDeleteSum();
        System.out.println(minimumDeleteSum.minimumDeleteSum("eat", "sea"));
    }
}
