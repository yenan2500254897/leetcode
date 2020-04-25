package prepare;

public class UniquePathsAchieve {

    public int uniquePaths(int m, int n) {

        if(m==0 || n==0){
            return 0;
        }

        int[][] record = new int[m][n];

        for(int row = 0;row<m;row++){
            for (int col = 0;col<n;col++){
                if(row == 0 && col == 0){
                    record[row][col] = 1;
                    continue;
                }
                if(row == 0){
                    record[row][col] = record[row][col-1];
                }else if(col == 0){
                    record[row][col] = record[row-1][col];
                }else {
                    record[row][col] = record[row][col-1] + record[row-1][col];
                }
            }
        }
        return record[m-1][n-1];
    }
}
