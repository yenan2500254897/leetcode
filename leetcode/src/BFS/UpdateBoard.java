package BFS;

import javafx.geometry.Pos;

import java.util.ArrayDeque;
import java.util.Queue;

public class UpdateBoard {


    public int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {

        //N表示行数
        int N = board.length;
        //M表示列数
        int M = board[0].length;

        //第一次点击的坐标
        int startR = click[0];
        int startC = click[1];

        //queue存储当前已访问的节点
        Queue<Position> queue = new ArrayDeque<Position>();
        //assistant用于存储下一轮要访问的节点
        Queue<Position> assistant = new ArrayDeque<Position>(){
            @Override
            public boolean contains(Object o) {
                if(this.isEmpty()){
                    return false;
                }
                Position input = (Position) o;
                for(Position position:this){
                    if(position.row == input.row && position.col == input.col){
                        return true;
                    }
                }
                return false;
            }
        };

        //初始化
        queue.add(new Position(startR, startC));
        //终止条件是queue为空
        while (!queue.isEmpty()){
            Position currentPos = queue.poll();

            int currentR = currentPos.row;
            int currentC = currentPos.col;
            char ch = board[currentR][currentC];

            //遇到地雷了
            if(ch == 'M'){
                board[currentR][currentC] = 'X';
                break;
            }

            //当前块是空白块
            if(ch == 'E'){
                int count = findBump(currentPos, N, M,board);
                board[currentR][currentC] = count == 0?'B':String.valueOf(count).charAt(0);
                //如果周围有雷，则不挖该空白块周围块
                if(count!=0){
                    continue;
                }

                //空白块周围没有雷
                int nextR = 0;
                int nextC = 0;

                for(int i=0;i<dir.length;i++){
                    nextR = currentR + dir[i][0];
                    nextC = currentC + dir[i][1];

                    //找出下一个位置为未挖出的空白块
                    if(nextR>=0 && nextR<N && nextC>=0 && nextC<M && board[nextR][nextC] == 'E'){
                        Position nextPos = new Position(nextR, nextC);
                        int bumpCount = findBump(nextPos, N, M, board);

                        //周围为无炸弹的未挖出的空白块，加入assistant
                        if(bumpCount == 0 ){
                            if(!assistant.contains(nextPos)){
                                assistant.add(nextPos);
                            }
                        }else {
                            board[nextR][nextC] = String.valueOf(bumpCount).charAt(0);
                        }
                    }
                }

                //将下一轮的位置，放入queue中
                if(queue.isEmpty()){
                    queue.addAll(assistant);
                    assistant.clear();
                }
            }


        }
        return board;
    }

    public int findBump(Position pos, int N, int M, char[][] board){
        int r = pos.row;
        int c = pos.col;

        int bumpCount = 0;
        for(int i=r-1;i<=r+1;i++){
            for(int j=c-1;j<=c+1;j++){
                //遇到未挖出的炸弹
                if(i>=0 && i<N && j>=0 && j<M && board[i][j] == 'M'){
                    bumpCount++;
                }
            }
        }
        return bumpCount;
    }

    public class Position{
        private int row;
        private int col;

        Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public void show(char[][] input){
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                System.out.print(" "  + input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        UpdateBoard updateBoard = new UpdateBoard();
        char[][] test = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        int[] click = {3,0};

//        char[][] test = {{'B','B','B','B','B','B','1','E'},{'B','1','1','1','B','B','1','M'},{'1','2','M','1','B','B','1','1'},{'M','2','1','1','B','B','B','B'},{'1','1','B','B','B','B','B','B'},{'B','B','B','B','B','B','B','B'},{'B','1','2','2','1','B','B','B'},{'B','1','M','M','1','B','B','B'}};
//        int[] click = {0, 7};

//        char[][] test = {{'E','M','M','2','B','B','B','B'},
//                {'E','E','M','2','B','B','B','B'},
//                {'E','E','2','1','B','B','B','B'},
//                {'E','M','1','B','B','B','B','B'},
//                {'1','2','2','1','B','B','B','B'},
//                {'B','1','M','1','B','B','B','B'},
//                {'B','1','1','1','B','B','B','B'},
//                {'B','B','B','B','B','B','B','B'}};
//        int[] click = {0, 0};
        updateBoard.show(test);
        System.out.println();
        char[][] update = updateBoard.updateBoard(test, click);
        updateBoard.show(update);
    }
}
