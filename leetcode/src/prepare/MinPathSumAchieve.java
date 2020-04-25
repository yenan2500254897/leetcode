package prepare;

public class MinPathSumAchieve {

    public int minPathSum(int[][] grid) {

        int row = grid.length;
        if (row == 0){
            return 0;
        }
        int col = grid[0].length;

        int[][] record = new int[row][col];
        record[0][0] = grid[0][0];
        for(int m=0;m<row;m++){
            for (int n=0;n<col;n++){
                if(m == 0 && n == 0){
                    continue;
                }

                if(m == 0){
                    record[m][n] = record[m][n-1]+grid[m][n];
                }else if(n == 0){
                    record[m][n] = record[m-1][n]+grid[m][n];
                }else {
                    record[m][n] = Math.min(record[m-1][n], record[m][n-1])+grid[m][n];
                }
            }
        }
        return record[row-1][col-1];
    }
}
