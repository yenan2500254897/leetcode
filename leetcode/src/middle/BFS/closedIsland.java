package middle.BFS;

import javax.sound.sampled.Line;

/**
 * 1254. 统计封闭岛屿的数目
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 *
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 *
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 *
 * 请返回封闭岛屿的数目。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * 示例 3：
 *
 * 输入：grid = [[1,1,1,1,1,1,1],
 *              [1,0,0,0,0,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,1,0,1,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,0,0,0,0,1],
 *              [1,1,1,1,1,1,1]]
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 *
 */
public class closedIsland {

    private boolean[][] visit;
    private int[][] dir= new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public int closedIsland(int[][] grid) {
        int len = grid.length;
        int width = grid[0].length;
        if(len<=2 || width<=2){
            return 0;
        }
        visit = new boolean[len][width];

        int result = 0;
        for(int x = 1;x<len-1;x++){
            for(int y = 1;y<width-1;y++){
                if(grid[x][y] == 0 && !visit[x][y]){
                    if(Bfs(grid, x, y)){
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private boolean Bfs(int[][] grid, int x, int y){
        //System.out.println("x: " + x + " y: " + y);
        //show();
        visit[x][y] = true;
        if(x==0 || x == grid.length-1 || y==0 || y==grid[0].length -1){
            if(grid[x][y] == 0){
                return false;
            }
            return true;
        }
//        if(grid[x][y] == 1){
//            return true;
//        }

        boolean result = true;
        for(int i =0;i<4;i++){
            if(grid[x+dir[i][0]][y+dir[i][1]] == 0 && !visit[x+dir[i][0]][y+dir[i][1]]){
                result &= Bfs(grid, x+dir[i][0],y+dir[i][1]);
            }
            if(grid[x+dir[i][0]][y+dir[i][1]] == 1){
                result &= true;
            }
        }
        return result;

    }

    private void show(){
        int len = visit.length;
        int width = visit[0].length;
        for(int x =0;x<len;x++){
            for(int y = 0;y<width;y++){
                System.out.print(" " + visit[x][y] + " ");
            }
            System.out.println();
        }
    }

}
