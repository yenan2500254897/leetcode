package BFS;

import javafx.geometry.Pos;

import javax.swing.text.Position;
import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumMoves {

    public int[][] horizontalDir = {{0, 1, 0, 1}, {1, 0, 1, 0}, {0, 0, 1, -1}};
    public int[][] plumbDir = {{1,0,1,0}, {0, 1, 0, 1}, {0, 0, -1, 1}};
    public int minimumMoves(int[][] grid) {
        int len = grid.length;

        //最终位置有阻隔
        if(grid[len-1][len-1] == 1 || grid[len-1][len-2] == 1){
            return -1;
        }
        return bfs(grid);
    }

    public int  bfs(int[][] grid){
        int len = grid.length;
        int step = 0;
        boolean[][] visited = new boolean[len][len];
        Queue<Position> queue =  new ArrayDeque<Position>(4);
        Position initPos = new Position(0,0, 0, 1);
        queue.add(initPos);

        boolean arriveFlag = false;
        //assitant用于记录下一轮蛇的位置，需要重载contains方法
        Queue<Position> assitant = new ArrayDeque<Position>(){
            @Override
            public boolean contains(Object o) {

                if(this.isEmpty()){
                    return false;
                }
                Position input = (Position)o;
                for(Position pos:this){
                    if(pos.tailr == input.tailr && pos.tailc == input.tailc
                            && pos.headr == input.headr && pos.headc == input.headc){
                        return true;
                    }
                }
                return false;
            }
        };

        //already用于记录之前蛇到过的位置
        Queue<Position> already = new ArrayDeque<Position>(){
            @Override
            public boolean contains(Object o) {

                if(this.isEmpty()){
                    return false;
                }
                Position input = (Position)o;
                for(Position pos:this){
                    if(pos.tailr == input.tailr && pos.tailc == input.tailc
                            && pos.headr == input.headr && pos.headc == input.headc){
                        return true;
                    }
                }
                return false;
            }
        };
        while (!queue.isEmpty()){
            Position tempPos = queue.poll();

//            System.out.println("current: tailr: " + tempPos.tailr + " tailc: "+ tempPos.tailc
//                              + " headr: " + tempPos.headr + " headc: " + tempPos.headc);

            if(tempPos.tailr == len-1 && tempPos.tailc == len-2
              && tempPos.headr == len-1 && tempPos.headc == len-1){
                arriveFlag = true;
                break;
            }

            int nextTailR = 0;
            int nextTailC = 0;
            int nextHeadR = 0;
            int nextHeadC = 0;
            Position nextPosition = null;
            //当前是水平状态
            if(tempPos.headr == tempPos.tailr){
                for(int i=0;i<horizontalDir.length;i++){
                    nextTailR = tempPos.tailr + horizontalDir[i][0];
                    nextTailC = tempPos.tailc + horizontalDir[i][1];
                    nextHeadR = tempPos.headr + horizontalDir[i][2];
                    nextHeadC = tempPos.headc + horizontalDir[i][3];

                    nextPosition = new Position(nextTailR, nextTailC, nextHeadR, nextHeadC);
                    if(nextTailR>=0 && nextTailR<len && nextTailC>=0 && nextTailC<len
                            &&nextHeadR>=0 && nextHeadR<len && nextHeadC>=0 && nextHeadC<len
                            && grid[nextTailR][nextTailC]!=1 && grid[nextHeadR][nextHeadC]!=1
                            && !assitant.contains(nextPosition)
                            && !already.contains(nextPosition)){
                        if(i == horizontalDir.length-1 && grid[nextHeadR][tempPos.headc]!=0){
                            continue;
                        }


//                        System.out.println("next: tailr: " + nextTailR + " tailc: "+ nextTailC
//                                + " headr: " + nextHeadR + " headc: " + nextHeadC);
                        assitant.add(nextPosition);

                    }
                }
            }else {
                //当前是垂直状态
                for(int i=0;i<plumbDir.length;i++){
                    nextTailR = tempPos.tailr + plumbDir[i][0];
                    nextTailC = tempPos.tailc + plumbDir[i][1];
                    nextHeadR = tempPos.headr + plumbDir[i][2];
                    nextHeadC = tempPos.headc + plumbDir[i][3];

                    nextPosition = new Position(nextTailR, nextTailC, nextHeadR, nextHeadC);
                    if(nextTailR>=0 && nextTailR<len && nextTailC>=0 && nextTailC<len
                            &&nextHeadR>=0 && nextHeadR<len && nextHeadC>=0 && nextHeadC<len
                            && grid[nextTailR][nextTailC]!=1 && grid[nextHeadR][nextHeadC]!=1
                            && !assitant.contains(nextPosition)
                            && !already.contains(nextPosition)){

                        if(i == plumbDir.length-1 && grid[tempPos.headr][nextHeadC]!=0){
                            continue;
                        }


//                        System.out.println("next: tailr: " + nextTailR + " tailc: "+ nextTailC
//                                + " headr: " + nextHeadR + " headc: " + nextHeadC);
                        assitant.add(nextPosition);

                    }
                }
            }

            if(queue.isEmpty()){
                step++;
                queue.addAll(assitant);
                already.addAll(assitant);
                assitant.clear();
//                System.out.println("clear assistant");
            }
        }

        return arriveFlag == true?step:-1;
    }


    public class Position{
        private int tailr;
        private int tailc;
        private int headr;
        private int headc;

        public Position(int tailr, int tailc, int headr, int headc){
            this.tailr = tailr;
            this.tailc = tailc;
            this.headr = headr;
            this.headc = headc;
        }

    }



    public static void main(String[] args){
        MinimumMoves minimumMoves = new MinimumMoves();
//        int[][] test =  {{0,0,0,0,0,1},{1,1,0,0,1,0},{0,0,0,0,1,1},{0,0,1,0,1,0},{0,1,1,0,0,0},{0,1,1,0,0,0}};
        int[][] test = {{0,0,0,0,0,0,0,0,0,1},
                        {0,1,0,0,0,0,0,1,0,1},
                        {1,0,0,1,0,0,1,0,1,0},
                        {0,0,0,1,0,1,0,1,0,0},
                        {0,0,0,0,1,0,0,0,0,1},
                        {0,0,1,0,0,0,0,0,0,0},
                        {1,0,0,1,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {1,1,0,0,0,0,0,0,0,0}};
        System.out.println(minimumMoves.minimumMoves(test));


    }



}
