package BFS;

import java.util.*;

public class CatMouseGame {

    private enum  Winner{
        UNKNOWN, MOUSEWIN, CATWIN
    }
    public int catMouseGame(int[][] graph) {

        int len = graph.length;
        Queue<State> queue = new ArrayDeque<State>();

        int[][][] record = new int[len][len][2];
        //老鼠在洞里，老鼠胜
        for(int i=1;i<len;i++){
            record[0][i][0] = 1;
            queue.add(new State(0, i, 0, 1));
            record[0][i][1] = 1;
            queue.add(new State(0, i, 1, 1));
        }

        //老鼠和猫在同一格里，则猫胜
        for(int i=1;i<len;i++){
            record[i][i][0] = 2;
            queue.add(new State(i, i, 0, 2));
            record[i][i][1] = 2;
            queue.add(new State(i, i, 1, 2));
        }

        while (!queue.isEmpty()){
            State currentState = queue.poll();
            int currentCatPosition = currentState.catCurrentPosition;
            int currentMousePosition = currentState.mouseCurrentPosition;
            int nextMove = currentState.nextMouseMove;
            int winner = currentState.winer;
            //System.out.println("currentMousePosition: " + currentMousePosition + " currentCatPosition: " + currentCatPosition + " nextMove: " + nextMove + " winner: " + winner);
            //当前轮到猫移动
            if(nextMove == 0){
                //当前是老鼠赢
                if(winner == 1){
                    for(int pre:graph[currentMousePosition]){
                        if(record[pre][currentCatPosition][1] == 0 && currentCatPosition!=0){
                            record[pre][currentCatPosition][1] = 1;
                            queue.add(new State(pre, currentCatPosition, 1, 1));
                            //System.out.println("set mousePosition: " + pre + " catPosition: " + currentCatPosition + " mouseMove: " + "yes" + " winner: " + "mouse");
                        }
                    }
                }

                //当前是猫赢
                if(currentState.winer == 2){

                    for(int pre:graph[currentMousePosition]){
                        boolean catWinFlag = true;
                        for(int preNext:graph[pre]){
                            if(record[preNext][currentCatPosition][0] != 2 && currentCatPosition!=0){
                                catWinFlag = false;
                                break;
                            }
                        }

                        if(catWinFlag && (record[pre][currentCatPosition][1] == 0) && currentCatPosition!=0){
                            record[pre][currentCatPosition][1] = 2;
                            queue.add(new State(pre, currentCatPosition, 1, 2));
                            //System.out.println("set mousePosition: " + pre + " catPosition: " + currentCatPosition + " mouseMove: " + "yes" + " winner: " + "cat");
                        }
                    }

                }
            }else {
                //当前轮到老鼠移动

                //当前是猫赢
                if(winner == 2){
                    for(int pre : graph[currentCatPosition]){
                        if(record[currentMousePosition][pre][0] == 0 && pre!=0){
                            record[currentMousePosition][pre][0] = 2;
                            queue.add(new State(currentMousePosition, pre, 0, 2));
                            //System.out.println("set mousePosition: " + currentMousePosition + " catPosition: " + pre + " mouseMove: " + "no" + " winner: " + "cat");
                        }
                    }
                }


                //当前是老鼠赢
                if(currentState.winer == 1){

                    for(int pre:graph[currentCatPosition]){
                        boolean mouseWinFlag = true;
                        for(int preNext:graph[pre]){
                            if(record[currentMousePosition][preNext][1] != 1 && preNext!=0){
                                mouseWinFlag = false;
                                break;
                            }
                        }

                        if(mouseWinFlag && (record[currentMousePosition][pre][0] == 0) && pre!=0){
                            record[currentMousePosition][pre][0] = 1;
                            queue.add(new State(currentMousePosition, pre, 0, 1));
                            //System.out.println("set mousePosition: " + currentMousePosition + " catPosition: " + pre + " mouseMove: " + "no" + " winner: " + "mouse");
                        }
                    }

                }

            }
        }
        return record[1][2][1];

    }

    public class State{
        private int catCurrentPosition;
        private int mouseCurrentPosition;
        private int nextMouseMove;
        private int winer;

        State(int mouseCurrentPosition, int catCurrentPosition, int nextMouseMove, int winer){
            this.mouseCurrentPosition = mouseCurrentPosition;
            this.catCurrentPosition = catCurrentPosition;
            this.nextMouseMove = nextMouseMove;
            this.winer = winer;
        }
    }


    public static void main(String[] args){
        CatMouseGame catMouseGame = new CatMouseGame();
        int[][] test = {{1,3},{0},{3},{0,2}};
        System.out.println(catMouseGame.catMouseGame(test));
    }
}
