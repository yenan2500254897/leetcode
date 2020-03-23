package middle.DFS;

import java.util.Scanner;

public class HasValidPath {

    private boolean isArrived = false;
    int[][] record;
    boolean[][] visited;
    int[][][] direction ;
    int[][] next ={{0,-1},{0,1},{-1,0},{1,0}};

    public boolean hasValidPath(int[][] grid) {
        if(grid == null){
            return isArrived;
        }

        int width = grid.length;
        int len = grid[0].length;

        visited= new boolean[width][len];
        record = grid;
        direction = new int[7][5][3];

        //1
        direction[1][3][0]=4;
        direction[1][3][1]=6;
        direction[1][3][2]=1;
        direction[1][4][0]=3;
        direction[1][4][1]=5;
        direction[1][4][2]=1;

        //2
        direction[2][1][0]=3;
        direction[2][1][1]=4;
        direction[2][1][2]=2;
        direction[2][2][0]=5;
        direction[2][2][1]=6;
        direction[2][2][2]=2;

        //3
        direction[3][2][0]=5;
        direction[3][2][1]=6;
        direction[3][2][2]=2;
        direction[3][3][0]=4;
        direction[3][3][1]=6;
        direction[3][3][2]=1;

        //4
        direction[4][2][0]=5;
        direction[4][2][1]=6;
        direction[4][2][2]=2;
        direction[4][4][0]=3;
        direction[4][4][1]=5;
        direction[4][4][2]=1;

        //5
        direction[5][1][0]=3;
        direction[5][1][1]=4;
        direction[5][1][2]=2;
        direction[5][3][0]=4;
        direction[5][3][1]=6;
        direction[5][3][2]=1;

        //6
        direction[6][1][0]=3;
        direction[6][1][1]=4;
        direction[6][1][2]=2;
        direction[6][4][0]=3;
        direction[6][4][1]=5;
        direction[6][4][2]=1;

        tranverse(0, 0);
        return isArrived;
    }

    public void tranverse(int m, int n){
        if(m==record.length - 1 && n==record[0].length-1){
            isArrived = true;
            return;
        }
        if(isArrived == true){
            return;
        }

        if(visited[m][n] == true){
            return;
        }

        visited[m][n] = true;

        int circle = next.length;
        for(int index =0;index<circle;index++){
            int nextn = n+next[index][0];
            int nextm = m+next[index][1];
            int value = record[m][n];
            if(nextm<0 || nextm>=record.length || nextn<0 || nextn>=record[0].length){
                continue;
            }
            if(record[nextm][nextn] == direction[value][index+1][0] || record[nextm][nextn] == direction[value][index+1][1]
            ||record[nextm][nextn] == direction[value][index+1][2]){
                tranverse(nextm, nextn);
            }
        }
        visited[m][n] = false;
    }

    public static void main(String[] args){
        int m = 2;
        int n = 3;
        Scanner scanner = new Scanner(System.in);
        int[][] inputs=new int[m][n];
        for(int i=0;i<m;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                int tempItem = scanner.nextInt();
                temp[j] = tempItem;
            }
            inputs[i] = temp;
        }

        HasValidPath hasValidPath = new HasValidPath();
        System.out.println(hasValidPath.hasValidPath(inputs));
    }
}
