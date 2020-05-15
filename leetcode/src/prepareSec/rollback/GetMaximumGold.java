package prepareSec.rollback;

public class GetMaximumGold {

    int[] dirR = {-1, 1, 0, 0};
    int[] dirC = {0, 0, -1, 1};
    public int getMaximumGold(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        int maxValue = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!=0){
                    visited[i][j] = true;
                    maxValue = Math.max(maxValue, go(grid, i, j, visited, grid[i][j]));
                    visited[i][j] = false;
                }
            }
        }
        return maxValue;
    }

    private int go(int[][] grid, int r, int c, boolean[][] visited, int currentTotal){
        int maxValue = currentTotal;
        for(int k=0;k<dirR.length;k++){
            int nextR = r+dirR[k];
            int nextC = c+dirC[k];

            if(nextR>=0 && nextR<grid.length && nextC>=0 && nextC<grid[0].length
            && visited[nextR][nextC] == false && grid[nextR][nextC]>0){
                visited[nextR][nextC] = true;
                maxValue = Math.max(maxValue, go(grid, nextR, nextC, visited, currentTotal+grid[nextR][nextC]));
                visited[nextR][nextC] = false;
            }
        }
        return maxValue;
    }

    public static void main(String[] args){
        GetMaximumGold getMaximumGold = new GetMaximumGold();
        int[][] test = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(getMaximumGold.getMaximumGold(test));
    }
}
