package middle.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *1162. 地图分析
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 *
 *
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *  
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 *
 */
public class maxDistance {
    int[][] dir = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public int maxDistance(int[][] grid) {

        int length = grid.length;
        int width = grid[0].length;
        boolean test1 = true;
        boolean test2 = true;

        for(int i=0;i<length;i++){
            for(int j=0;j<width;j++){
                test1 = test1 &&  (grid[i][j] == 0);
                test2 = test2 && (grid[i][j] == 1);
            }
        }
        if(test1 || test2){
            return -1;
        }

        int result = Integer.MIN_VALUE;
        for(int indexX =0;indexX<length;indexX++){
            for(int indexY = 0;indexY<width;indexY++){
                if(grid[indexX][indexY] == 0){
                    boolean[][] visit = new boolean[length][width];
                    int tempValue = findDistance(grid, visit, indexX, indexY, 0);
                    //System.out.println("x: " + indexX + " y: " + indexY + " distances: " + tempValue);
                    if(tempValue > result){
                        result = tempValue;
                    }
                }
            }
        }

        return result;
    }

    public int findDistance(int[][] grid,boolean[][] visit, int x, int y, int distance){
        visit[x][y] = true;
        List<Integer> temp = new ArrayList<>();
        if(grid[x][y] == 0){
            temp.add(x);
            temp.add(y);
        }
        List<Integer> preList = new ArrayList<>();
        //System.out.println("begin x: " + x + " y: " + y + " distances: " + distance);
        while(!temp.isEmpty()){
            //show(visit);
            //System.out.println(temp);
            int tempX = temp.get(0);
            int tempY = temp.get(1);
            temp.remove(0);
            temp.remove(0);
            for(int index=0;index<4;index++){
                int nextX = tempX + dir[index][0];
                int nextY = tempY + dir[index][1];
                //System.out.println("x: " + nextX + " y: " + nextY + " distances: " + distance);
                if(nextX>=0 && nextX<visit.length && nextY>=0 && nextY<visit[0].length && visit[nextX][nextY] == false){

                    visit[nextX][nextY] = true;
                    if(grid[nextX][nextY] == 0){
                        preList.add(nextX);
                        preList.add(nextY);
                    }else{
                        //System.out.println("result x: " + nextX + " y: " + nextY + " distances: " + calDistance(x,y,nextX,nextY));
                        return calDistance(x,y,nextX,nextY);
                    }
                }
            }
            if(temp.isEmpty()){
                temp.addAll(preList);
                preList.clear();
            }
        }
        return distance;
    }

    public int calDistance(int preX, int preY, int nextX, int nextY){
        return Math.abs(preX-nextX) + Math.abs(preY-nextY);
    }

    public void show(boolean[][] record){
        int length = record.length;
        int width = record[0].length;
        for(int i=0;i<length;i++){
            for(int j=0;j<width;j++){
                System.out.print(" " + record[i][j]+" ");
            }
            System.out.println();
        }
    }


}
