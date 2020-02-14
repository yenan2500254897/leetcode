package middle.DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class shortestPathBinaryMatrix {

    public static int valid = 0;
    public static int invalid = 1;
    public static int[][] dir = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;

        int[][] result = new int[length][width];

        if(grid[0][0] == invalid || grid[length-1][width-1] == invalid){
            return -1;
        }

        //System.out.println("go there");
        for(int i = 0;i<length;i++){
            for(int j = 0;j<width;j++){
                result[i][j] = 65535;
            }
        }
        result[0][0] = 1;
        for(int x =0;x<length;x++){
            for(int y =0;y<width;y++){
                //System.out.println("x: " + x + " y: " + y);
                if(grid[x][y] == valid){
                    int nextx = 0;
                    int nexty = 0;
                    for(int[] item:dir){
                        nextx = x + item[0];
                        nexty = y + item[1];
                        if(nextx >=0 && nextx < length && nexty>=0 && nexty<width && grid[nextx][nexty] == valid){
                            //System.out.println("nextx: " + nextx + " nexty: " + nexty);
                            if(result[nextx][nexty] > result[x][y]+1){
                                result[nextx][nexty] = result[x][y]+1;
                            }
                        }
                    }
                    //show(result);
                }
            }
        }
        //show(result);
        if(result[length -1][width-1] == 65535){
            return -1;
        }
        return result[length -1][width-1];
    }

//    public int shortestPathBinaryMatrix(int[][] grid) {
//        int length = grid.length;
//        int width = grid[0].length;
//
//        int[][] result = new int[length][width];
//
//        if(grid[0][0] == invalid || grid[length-1][width-1] == invalid){
//            return -1;
//        }
//
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(0);
//        queue.add(0);
//        int step = 1;
//        List<Integer> list = new ArrayList<>();
//        while (!queue.isEmpty()){
//            int x = queue.poll();
//            int y = queue.poll();
//
//            for(int[] item: dir){
//                int nextX = x + item[0];
//                int nextY = y + item[1];
//                if(nextX>=0 && nextX< length && nextY>=0 && nextY<width &&  grid[nextX][nextY] == valid){
//                    if(nextX == length-1 && nextY==width-1){
//                        return step+1;
//                    }
//                    list.add(nextX);
//                    list.add(nextY);
//                }
//            }
//            grid[x][y] = invalid;
//            step++;
//            if(queue.isEmpty()){
//                queue.addAll(list);
//                list.clear();
//            }
//        }
//        return step;
//    }

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
}
