package middle.DynamicProgramming;

import com.sun.org.apache.regexp.internal.RE;
import javafx.scene.input.SwipeEvent;
import sun.font.GlyphLayout;

/**
 * 1314. 矩阵区域和
 * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
 *
 * i - K <= r <= i + K, j - K <= c <= j + K 
 * (r, c) 在矩阵内。
 *  
 *
 * 示例 1：
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * 示例 2：
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 *  
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 *

 */
public class MatrixBlockSum {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int length = mat.length;
        int width = mat[0].length;

        int[][] result = new int[length][width];


        for(int x=0;x<length;x++){
            for(int y=0;y<width;y++){
                result[x][y] = calValue(mat,x-K, y-K,x+K,y+K);

            }
        }
        return result;
    }

    public int calValue(int[][] mat, int startX, int startY, int endX, int endY){
        int result =0;

        for(int i=startX;i<=endX;i++){
            for(int j=startY;j<=endY;j++){
                if(i>=0 && i<mat.length && j>=0 && j<mat[0].length){
                    result += mat[i][j];
                }
            }
        }
        return result;
    }
}
