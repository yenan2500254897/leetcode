package prepareSec.dp;

import middle.DynamicProgramming.MaxSizeSlices;

public class MaxStudents {

    public int maxStudents(char[][] seats) {

        int row =seats.length;
        int col = seats[0].length;
        int[][] dp = new int[row+1][1<<col];

        for(int i=1;i<=row;i++){
            for(int preMask =0;preMask<1<<col;preMask++){
                for(int mask = 0;mask<1<<col;mask++){
                    if(isValid(preMask, mask, seats, i-1)){
                        dp[i][mask] = Math.max(dp[i][mask], Integer.bitCount(mask)+ dp[i-1][preMask]);
                    }
                }
            }
        }

        int result =0;
        for(int i=0;i<1<<col;i++){
            if(dp[row][i]>result){
                result = dp[row][i];
            }
        }
        return result;
    }

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


    public static void main(String[] args){
        MaxStudents maxStudents = new MaxStudents();
        char[][] test = {{'#','.','.','.','#'}};
        System.out.println(maxStudents.maxStudents(test));
    }

}
