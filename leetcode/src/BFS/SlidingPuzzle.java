package BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SlidingPuzzle {


    public int slidingPuzzle(int[][] board) {
        int[][] finishArray = {{1,2,3}, {4,5,0}};
        if(isEqaul(finishArray, board)){
            return 0;
        }

        int[][] dir = {{-1, 0,}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Position> queue = new ArrayDeque<Position>(4){
            @Override
            public boolean contains(Object o) {
                Position currentPosition = (Position) o;
                for(Position position : this){
                    if(isEqaul(position.array, currentPosition.array)){
                        return true;
                    }
                }
                return false;
            }
        };;
        Queue<Position> assistant = new ArrayDeque<Position>(4){
            @Override
            public boolean contains(Object o) {
                Position currentPosition = (Position) o;
                for(Position position : this){
                    if(isEqaul(position.array, currentPosition.array)){
                        return true;
                    }
                }
                return false;
            }
        };

        Queue<Position> already = new ArrayDeque<Position>(4){
            @Override
            public boolean contains(Object o) {
                Position currentPosition = (Position) o;
                for(Position position : this){
                    if(isEqaul(position.array, currentPosition.array)){
                        return true;
                    }
                }
                return false;
            }
        };

        //初始化
        int[] initZeroPosition = findZero(board);
        Position initPosition = new Position(board, initZeroPosition[0], initZeroPosition[1]);
        queue.add(initPosition);
        already.add(initPosition);
        int step = 0;
        boolean flag = false;

        while (!queue.isEmpty()){

            Position currentPos = queue.poll();
            if(isEqaul(currentPos.array, finishArray)){
                flag = true;
                break;
            }

            int currentR = currentPos.zeroR;
            int currentC = currentPos.zeroC;
            int[][] currentArray = currentPos.array;
            for(int i=0;i<dir.length;i++){
                int nextR = currentR + dir[i][0];
                int nextC = currentC + dir[i][1];
                if(nextR>=0 && nextR<board.length && nextC>=0 && nextC<board[0].length){
                    int[][] nextArray = swap(currentArray, currentR, currentC, nextR, nextC);
                    Position nextPosition = new Position(nextArray, nextR, nextC);
                    if(!queue.contains(nextPosition) && !assistant.contains(nextPosition) && !already.contains(nextPosition)){
                        assistant.add(nextPosition);
                    }
                }
            }

            if(queue.isEmpty()){
                queue.addAll(assistant);
                already.addAll(assistant);
                assistant.clear();
                step++;
            }

        }
        return flag == true?step:-1;
    }

    public boolean isEqaul(int[][] pre, int[][] next){
        for(int i=0;i<pre.length;i++){
            for(int j=0;j<pre[0].length;j++){
                if(pre[i][j]!=next[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public int[] findZero(int[][] array){
        int[] result = new int[2];
        boolean flag = false;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(array[i][j] == 0){
                    result[0] = i;
                    result[1] = j;
                    flag = true;
                    break;
                }
            }
            if(flag == true){
                break;
            }
        }
        return result;
    }

    public int[][] swap(int[][] array, int currentR, int currentC, int nextR, int nextC){
        int[][] result = new int[array.length][array[0].length];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                result[i][j] = array[i][j];
            }
        }

        int temp = result[currentR][currentC];
        result[currentR][currentC] = result[nextR][nextC];
        result[nextR][nextC] = temp;
        return result;
    }

    public class Position{
        int[][] array;
        int zeroR;
        int zeroC;

        Position(int[][] array, int r, int c){
            this.array = array;
            this.zeroR = r;
            this.zeroC = c;
        }
    }


    public static void main(String[] args){
//       int[][] test = {{1,2,3},{4,0,5}};
//        int[][] test =  {{1,2,3},{5,4,0}};
        int[][] test = {{4,1,2},{5,0,3}};
       SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
       System.out.println(slidingPuzzle.slidingPuzzle(test));
    }

}
