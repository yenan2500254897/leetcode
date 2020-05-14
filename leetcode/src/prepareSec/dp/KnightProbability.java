package prepareSec.dp;

public class KnightProbability {

    public double knightProbability(int N, int K, int r, int c) {

        double[][] dp = new double[N][N];

        dp[r][c] = 1.0;

        int[] dirR = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dirC = {1, -1, 1, -1, 2, -2, 2, -2};

        for(;K>0;K--){
            int nextr = 0;
            int nextc = 0;
            double[][] dp2 = new double[N][N];
            for(int sr=0;sr<N;sr++){
                for(int sc=0;sc<N;sc++){
                    for(int j=0;j<8;j++){
                        nextr = sr + dirR[j];
                        nextc = sc + dirC[j];
                        if(nextr>=0 && nextr<N && nextc>=0 && nextc<N){
                            dp2[nextr][nextc] += dp[sr][sc]/8.0;
                        }
                    }

                }
            }
            dp = dp2;
        }

        double result = 0;
        for(double[] row:dp){
            for(double item:row){
                result+=item;
            }
        }
        return result;
    }



}
