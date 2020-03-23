package middle.DFS;

import utils.TransferToIntegerArray;

import java.util.*;

/**
 * 1091. 二进制矩阵中的最短路径
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[0,1],[1,0]]
 *
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：[[0,0,0],[1,1,0],[1,1,0]]
 *
 * 输出：4
 *
 *  
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 *
 */
public class ShortestPathBinaryMatrix {

    public static int valid = 0;
    public static int invalid = 1;
    public static int[][] dir = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
    public static boolean[][] visit;
    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        //show(grid);
        //System.out.println("length: " + length + " width: "+ width)；

        if(grid[0][0] == invalid || grid[length-1][width-1] == invalid){
            //System.out.println("exit");
            return -1;
        }
        int step = 1;
        if(length == 1){
            return step;
        }
        visit = new boolean[length][width];
        Queue<List<Integer>> lists = new ArrayDeque<>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(0);
        lists.add(list);
        visit[0][0] = true;
        List<List<Integer>> layer = new ArrayList<>();
        while(!lists.isEmpty()){
            List<Integer> firstNode = lists.poll();
            int x = firstNode.get(0);
            int y = firstNode.get(1);

            for(int[] item:dir){
                int nextX = x+item[0];
                int nextY = y+item[1];

                if(nextX == length-1 && nextY == width-1){
                    return step+1;
                }

                if(nextX>=0 && nextX<length && nextY>=0 && nextY<length && grid[nextX][nextY] == valid && visit[nextX][nextY] == false){
                    //System.out.println("x="+x + " y="+y);
                    //System.out.println("nextX="+nextX + " nextY="+nextY);
                    List<Integer> assist = new ArrayList<Integer>();
                    assist.add(nextX);
                    assist.add(nextY);
                    layer.add(assist);
                    visit[nextX][nextY] = true;
                }

            }
            grid[x][y] = invalid;
            //visit[x][y] = true;

            if(lists.isEmpty()){
                lists.addAll(layer);
                step++;
                layer.clear();
                //System.out.println("step="+step);
            }
        }
        return -1;
    }

    public void show(int[][] record){
        int length = record.length;
        int width = record[0].length;
        for(int i=0;i<length;i++){
            for(int j=0;j<width;j++){
                System.out.print(" " + record[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        TransferToIntegerArray transferToIntegerArray = new TransferToIntegerArray();
        int[][] input =  transferToIntegerArray.execute();
        ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();
        int result = shortestPathBinaryMatrix.shortestPathBinaryMatrix(input);
        System.out.println(result);

    }
}
