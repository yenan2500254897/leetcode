package BFS;

import java.util.*;

public class PondSizes {
    int[][] dir = {{-1, 0}, {1, 0},{0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public int[] pondSizes(int[][] land) {
        int m =land.length;
        int n = land[0].length;

        boolean[][] visited = new boolean[m][n];

        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(land[i][j] == 0 && visited[i][j] == false){
                    list.add(bfs(i, j, land, visited));
                }
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        int len = list.size();
        int[] result = new int[len];
        for(int i=0;i<len;i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public int bfs(int i, int j, int[][] land, boolean[][] visited){
        Queue<Position> queue = new ArrayDeque<Position>(1);
        Queue<Position> assistant = new ArrayDeque<Position>(1);
        Position initPosition = new Position(i, j);
        queue.add(initPosition);
        visited[i][j] = true;
        int total = 0;
        while (!queue.isEmpty()){
            Position currentPos = queue.poll();
            int currentR = currentPos.row;
            int currentC = currentPos.col;
            total++;

            for(int index = 0;index<dir.length;index++){
                int nextR = currentR + dir[index][0];
                int nextC = currentC + dir[index][1];

                if(nextR>=0 && nextR<land.length && nextC>=0 && nextC<land[0].length
                && land[nextR][nextC] == 0 && visited[nextR][nextC] == false){
                    assistant.add(new Position(nextR, nextC));
                    visited[nextR][nextC] = true;
                }
            }

            if(queue.isEmpty()){
                queue.addAll(assistant);
                assistant.clear();
            }
        }
        return total;
    }

    public class Position{
        private int row;
        private int col;

        Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public void show(int[] result){
        for(int item: result){
            System.out.print(" " + item + " ");
        }
    }

    public static void main(String[] args){
        int[][] test = {{0,2,1,0}, {0,1,0,1}, {1,1,0,1}, {0,1,0,1}};
        PondSizes pondSizes = new PondSizes();
        int[] result = pondSizes.pondSizes(test);
        pondSizes.show(result);
    }
}
