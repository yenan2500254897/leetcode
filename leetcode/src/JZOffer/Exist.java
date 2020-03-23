package JZOffer;

import utils.TransferToIntegerArray;

import java.util.Arrays;

public class Exist {

    public char[][] chars;
    public String target;
    int[][] direction =new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        chars = board;
        target = word;

        int len = board[0].length;
        int width = board.length;

         for(int j=0;j<width;j++){
             for(int i=0;i<len;i++){
                 System.out.print(" "+ chars[j][i]+" ");
             }
             System.out.println();
         }

        for(int j=0;j<width;j++){
            for(int i=0;i<len;i++){
                if(board[j][i] == word.charAt(0)){
                    boolean[][] visited = new boolean[width][len];
                    if(findPath(i,j,0,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean findPath(int x, int y , int index,boolean[][] visited){
        System.out.println("x: " + x + " y: "+ y + " index: " + index);
        int len = chars[0].length;
        int width = chars.length;
        if(x<0 || x>=len || y<0 || y>=width || chars[y][x] != target.charAt(index) || visited[y][x]){
            return false;
        }

        if(index == target.length()-1){
            return true;
        }
        visited[y][x] = true;

        boolean flag =findPath(x-1,y,index+1,visited) || findPath(x+1, y,index+1,visited)
                ||findPath(x,y-1,index+1,visited) || findPath(x, y+1,index+1,visited);

        visited[y][x] = false;
        return flag;
    }

    public static void main(String[] args) throws Exception{
        TransferToIntegerArray transferToIntegerArray = new TransferToIntegerArray();
        String filePath = "C:\\Users\\yn\\IdeaProjects\\leetcode\\leetcode\\";
        final String fileName = "test.txt";
        char[][] input = transferToIntegerArray.toTwoDimCharArray(filePath+fileName);
        Exist exist = new Exist();
        String str = "ABCESEEEFS";
        System.out.println(exist.exist(input, str));
    }
}
