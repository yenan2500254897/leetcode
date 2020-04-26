package prepare;

public class CountSquaresAchieve {

    public int countSquares(int[][] matrix) {

        int row = matrix.length;
        if(row == 0){
            return 0;
        }
        int col = matrix[0].length;

        int total = 0;
        for(int m=0;m<row;m++){
            for(int n=0;n<col;n++){
                int circle = Math.min(row-m, col-n);
                boolean flag = true;
                for(int i=1;i<=circle;i++){
                    if(isValid(matrix, m, n, i)){
                        total++;
                    }else {
                        break;
                    }
                }
            }
        }
        return total;
    }

    public boolean isValid(int[][] matrix, int row, int col, int len){
        boolean result = true;

        for(int i=row;i<row+len;i++){
            for(int j=col;j<col+len;j++){
                result = result && (matrix[i][j] == 1);
                if(result == false){
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[][] test = new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        CountSquaresAchieve item = new CountSquaresAchieve();
        System.out.println(item.countSquares(test));
    }
}
