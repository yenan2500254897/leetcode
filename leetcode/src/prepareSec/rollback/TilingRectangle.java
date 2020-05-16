package prepareSec.rollback;

import com.sun.org.apache.regexp.internal.RE;

public class TilingRectangle {

    public int tilingRectangle(int n, int m) {

        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j] = i==j?1:i*j;

                for(int p = 1;p<i;p++){
                    dp[i][j] = Math.min(dp[i][j], dp[p][j]+dp[i-p][j]);
                }

                for(int p = 1;p<j;p++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][p]+dp[i][j-p]);
                }

                for(int x=1;x<i;x++){
                    for(int y=2;y<j;y++){
                        dp[i][j] = Math.min(dp[i][j], dp[x][y] + dp[x+1][j-y] + dp[i-x-1][j-y+1] + dp[i-x][y-1] + 1);
                    }
                }
            }
        }

        return dp[n][m];
    }



    public static void main(String[] args){
        TilingRectangle tilingRectangle = new TilingRectangle();
        System.out.println(tilingRectangle.tilingRectangle(11,7));
    }
}
