package BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ShortestPathLength {

    public int shortestPathLength(int[][] graph) {

        int N = graph.length;

        int[][] distance = new int[1<<N][N];
        for(int[] row:distance){
            Arrays.fill(row, N*N);
        }
        Queue<State> queue = new ArrayDeque<State>(4);

        for(int i=0;i<N;i++){
            queue.add(new State(1<<i, i));
            distance[1<<i][i] = 0;
        }

        while (!queue.isEmpty()){
            State temp = queue.poll();

            if(temp.cover == (1<<N)-1){
                return distance[temp.cover][temp.head];
            }

            for(int current: graph[temp.head]){
                int cover2 = temp.cover | 1<<current;


                if(distance[temp.cover][temp.head] + 1 < distance[cover2][current]){
                    distance[cover2][current] = distance[temp.cover][temp.head] + 1;
                    queue.add(new State(cover2, current));
                }
            }
        }
        return 0;
    }

    private class State{
        private int cover;
        private int head;

        public State(int cover, int head){
            this.cover = cover;
            this.head = head;
        }
    }
}
