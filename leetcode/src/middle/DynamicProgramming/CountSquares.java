package middle.DynamicProgramming;

import utils.TransferToIntegerArray;

/**
 * 1277. 统计全为 1 的正方形子矩阵
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 *
 * 输入：matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 *
 */
public class CountSquares {

    public static final String filePath = "C:\\Users\\yn\\IdeaProjects\\leetcode\\leetcode\\";
    public static final String fileName = "test.txt";
    public static int valid = 1;
    public int countSquares(int[][] matrix) {
        int length = matrix.length;
        int width = matrix[0].length;

        int squareCount = 0;
        for(int i = 0;i<length;i++){
            for(int j=0;j<width;j++){
                if(matrix[i][j] != valid){
                    continue;
                }
                int circle = Math.min(length-i,width-j);
                for(int k=1;k<=circle;k++){
                    //System.out.println(i + " " + j + " "+ k);
                    if(isSquares(i,j,k,matrix)){
                        //System.out.println(isSquares(i,j,k,matrix));
                        squareCount++;
                    }else {
                        break;
                    }
                }
                //System.out.println("go there");
            }
        }
        return squareCount;
    }

    public boolean isSquares(int indexX, int indexY, int width, int[][] input){
        //System.out.println("go there");
        boolean result = true;

        for(int i=indexX;i<indexX+width;i++){
            for(int j=indexY;j<indexY+width;j++){
                //System.out.println("go there");
                if(input[i][j] != valid){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        TransferToIntegerArray transferToIntegerArray = new TransferToIntegerArray();
        int[][] input = transferToIntegerArray.toTwoDimArray(filePath+fileName);
        CountSquares countSquares = new CountSquares();
        System.out.println(countSquares.countSquares(input));
    }
}
