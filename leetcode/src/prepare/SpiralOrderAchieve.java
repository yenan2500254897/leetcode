package prepare;

import java.util.LinkedList;
import java.util.List;

public class SpiralOrderAchieve {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new LinkedList<>();
        //为空的情况
        if(matrix == null || matrix.length == 0){
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        //取行数与列数中的较小值
        for(int i=0;i<=Math.min((m-1)/2, (n-1)/2);i++){

            int rowLimit = m-i-1;
            int colLimit = n-i-1;

            //对待一行的情况
            if(i==rowLimit){
                int j=i;
                while (j<=colLimit){
                    result.add(matrix[i][j]);
                    j++;
                }
                continue;
            }

            //对待一列的情况
            if(i==colLimit){
                int j=i;
                while (j<=rowLimit){
                    result.add(matrix[j][i]);
                    j++;
                }
                continue;
            }

            int x=i;
            int y=i;
            //向右
            while(y<colLimit){
                result.add(matrix[x][y]);
                y++;
            }

            //向下
            while(x<rowLimit){
                result.add(matrix[x][y]);
                x++;
            }

            //向左
            while(y>i){
                result.add(matrix[x][y]);
                y--;
            }

            //向上
            while(x>i){
                result.add(matrix[x][y]);
                x--;
            }


        }
        return result;

    }
}
