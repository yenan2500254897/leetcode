package JZOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class movingCount {
    int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int movingCount(int m, int n, int k) {
        if(k<0){
            return 0;
        }
        if(k==0){
            return 0;
        }
        Queue<Integer> queue = new ArrayDeque();
        Queue<Integer> assistant = new ArrayDeque();
        boolean[][] visited = new boolean[m][n];
        int total = 1;
        queue.add(0);
        queue.add(0);
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int row = queue.poll();
            int col = queue.poll();
            for(int i=0;i<directions.length;i++){
                int nextRow = row + directions[i][0];
                int nestCol = col + directions[i][1];
                if(nextRow>=0 && nextRow<m && nestCol>=0 && nestCol<n && !visited[nextRow][nestCol]){
                    visited[nextRow][nestCol] = true;
                    if(calTotal(nextRow) + calTotal(nestCol)<=k){
                        assistant.add(nextRow);
                        assistant.add(nestCol);
                        total++;
                    }
                }
            }

            if(queue.isEmpty() && !assistant.isEmpty()){
                queue.addAll(assistant);
                assistant.clear();
            }
        }
        return total;

    }
    int calTotal(int value){
        int total = 0;
        while(value!=0){
            total += value%10;
            value /= 10;
        }
        return total;
    }
}
