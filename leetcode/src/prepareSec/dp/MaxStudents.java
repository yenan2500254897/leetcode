package prepareSec.dp;

import middle.DynamicProgramming.MaxSizeSlices;

public class MaxStudents {

//    public int maxStudents(char[][] seats) {
//
//        int row =seats.length;
//        int col = seats[0].length;
//        int[][] dp = new int[row+1][1<<col];
//
//        for(int i=1;i<=row;i++){
//            for(int preMask =0;preMask<1<<col;preMask++){
//                for(int mask = 0;mask<1<<col;mask++){
//                    if(isValid(preMask, mask, seats, i-1)){
//                        dp[i][mask] = Math.max(dp[i][mask], Integer.bitCount(mask)+ dp[i-1][preMask]);
//                    }
//                }
//            }
//        }
//
//        int result =0;
//        for(int i=0;i<1<<col;i++){
//            if(dp[row][i]>result){
//                result = dp[row][i];
//            }
//        }
//        return result;
//    }
//
    private boolean isValid(int preMask, int mask, char[][] seats, int row){
        int col = seats[0].length;

        for(int i=0;i<col;i++){
            if((mask & (1<<i)) == 0){
                continue;
            }

            if(seats[row][i] == '#'){
                return false;
            }

            if(row >= 0 && i-1>=0 && seats[row][i-1] == '.' && (mask & 1<<(i-1)) != 0){
                return false;
            }

            if(row >= 0 && i+1<col && seats[row][i+1] == '.' && (mask & 1<<(i+1)) != 0){
                return false;
            }

            if(row -1>=0 && i-1>=0 && (preMask & 1<<(i-1)) != 0 && seats[row-1][i-1] == '.' ){
                return false;
            }

            if(row -1>=0 && i+1<col && (preMask & 1<<(i+1)) != 0 && seats[row-1][i+1] == '.'){
                return false;
            }
        }

        return true;
    }

    private int dfs(char[][] seats, int row, int mask, Integer memo[][]){
        if(row <0){
            return 0;
        }

        if(memo[row][mask]!=null){
            return memo[row][mask];
        }

        int col = seats[0].length;
        for(int i=0;i<1<<col;i++){
            if(isValid(i, mask, seats, row) && isValid(0,i,seats, row==0?0:row-1)){
                if(row-1<0){
                    memo[row][mask] = Integer.bitCount(mask);
                    continue;
                }

                if(memo[row-1][i] == null){
                    memo[row-1][i] = dfs(seats, row-1, i, memo);
                }
                if(memo[row][mask] == null || memo[row-1][i] + Integer.bitCount(mask)>memo[row][mask]){
                    memo[row][mask] = memo[row-1][i] + Integer.bitCount(mask);
                }
            }
        }
        return memo[row][mask];
    }

    public int maxStudents(char[][] seats) {
        int row = seats.length;
        int col = seats[0].length;
        Integer[][] memo = new Integer[row][1<<col];
        int maxValue = 0;
        for(int i=0;i<1<<col;i++){
            if(isValid(0, i, seats, row-1)){
                maxValue = Math.max(dfs(seats, row-1, i, memo), maxValue);
            }
        }

        return maxValue;
    }


    public static void main(String[] args){
        MaxStudents maxStudents = new MaxStudents();
        char[][] test = {{'#','.','#','#','.','#'},
                {'.','#','#','#','#','.'},
                {'#','.','#','#','.','#'}};
        System.out.println(maxStudents.maxStudents(test));
    }

}
