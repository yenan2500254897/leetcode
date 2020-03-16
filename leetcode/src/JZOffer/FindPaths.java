package JZOffer;

public class FindPaths {
//    private int paths=0;
//    int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};
//    public int findPaths(int m, int n, int N, int i, int j) {
//        if(N<=0){
//            return paths;
//        }
//        boolean[][] visited = new boolean[m][n];
//        go(m,n,N,i,j,visited,0);
//        return paths;
//    }
//
//    public void go(int m, int n, int N, int i, int j,boolean[][] visited,int steps){
//        if(steps>N){
//            return;
//        }
//        if(i<0 || i>=m || j<0 || j>=n){
//            paths++;
//            return;
//        }
//        if(visited[i][j] ){
//            return;
//        }
//        for(int circle=0;circle<directions.length;circle++){
//            visited[i][j] = true;
//            go(m,n,N,i+directions[circle][0],j+directions[circle][1],visited, steps+1);
//            visited[i][j] = false;
//        }
//    }

    int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};
    public int findPaths(int m, int n, int N, int i, int j) {
        if(N<=0){
            return 0;
        }
        long[][][] record = new long[m][n][N+1];
        for(int step=1;step<=N;step++){
            for(int row=0;row<m;row++){
                for (int col=0;col<n;col++){
                    if(step==1){
                        for(int dir=0;dir<directions.length;dir++){
                            int nextRow = row+directions[dir][0];
                            int nextCol = col+directions[dir][1];
                            if(nextRow<0 || nextRow>=m || nextCol<0 || nextCol>=n){
                                record[row][col][step]++;
                            }
                        }
                    }else {
                        for(int dir=0;dir<directions.length;dir++){
                            int nextRow = row+directions[dir][0];
                            int nextCol = col+directions[dir][1];
                            if(nextRow>=0 && nextRow<m && nextCol>=0 && nextCol<n){
                                record[row][col][step] += record[nextRow][nextCol][step-1];
                            }else {
                                record[row][col][step] +=1;
                            }

                        }
                    }
                }
            }
        }
        return (int)(record[i][j][N]%1000000007);
    }

    public static void main(String[] args){
        FindPaths test = new FindPaths();
        test.findPaths(1,3,3,0,1);
    }
}
