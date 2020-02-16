package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TransferToIntegerArray {

    public static final String filePath = "C:\\Users\\yn\\IdeaProjects\\leetcode\\leetcode\\";
    public static final String splitWord = ",";
    public static final String secSplitWord = "],[";
    public int[] toOneDimArray(String fileName) throws FileNotFoundException {
        File inputFile = new File(fileName);

        Scanner in = new Scanner(inputFile);
        String[] resultString = new String[0];
        if (in.hasNext()){
            String line = in.nextLine();
            //System.out.println(line);
            line = line.substring(1,line.length()-1);
            //System.out.println(line);
            resultString = line.split(splitWord);
        }
        int[] result = new int[resultString.length];
        for(int index = 0; index<resultString.length;index++){
            result[index] = Integer.valueOf(resultString[index]);
        }
        return result;
    }

    public void showOneDimArray(int[] input){
        for(int item:input){
            System.out.print(" " + item + " ");
        }
    }

    public int[][] toTwoDimArray(String fileName) throws FileNotFoundException {
        File inputFile = new File(fileName);

        Scanner in = new Scanner(inputFile);
        List<List<Integer>> lists = new ArrayList<>();
        String[] resultString = new String[0];
        if (in.hasNext()){
            String line = in.nextLine();
            //System.out.println(line);
            line = line.substring(1,line.length()-1);
            //System.out.println(line);
            resultString = line.split(splitWord);
        }

        List<Integer> tempList = new ArrayList<>();
        int width = 0;
        for(String iter:resultString){
            if(iter.contains("[")){
                //System.out.println(iter.substring(1));
                tempList.add(Integer.valueOf(iter.substring(1)));
            }else if(iter.contains("]")){
                //System.out.println(iter.substring(0,iter.length()-1));
                tempList.add(Integer.valueOf(iter.substring(0,iter.length()-1)));
                if(tempList.size() > width){
                    width = tempList.size();
                }
                lists.add(new ArrayList<>(tempList));
                tempList.clear();
            }else {
                tempList.add(Integer.valueOf(iter));
            }
        }

        int len = lists.size();
        int[][] result = new int[len][width];
        for(int i=0;i<len;i++){
            for(int j=0;j<width;j++){
                //System.out.println("i: " + i + " j：" + j + " value:" + lists.get(i).get(j).intValue());
                result[i][j] = lists.get(i).get(j);
            }
        }

        return result;
    }


    public void showTwoDimArray(int[][] input){
        for(int[] item:input){
            for(int i:item){
                System.out.print(" " + i + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        String fileName = "test.txt";
        TransferToIntegerArray transferToIntegerArray = new TransferToIntegerArray();
        try{
            //transferToIntegerArray.showOneDimArray(transferToIntegerArray.toOneDimArray(filePath + fileName));
            transferToIntegerArray.showTwoDimArray(transferToIntegerArray.toTwoDimArray(filePath + fileName));
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public int[][] execute(){
        String fileName = "test.txt";
        TransferToIntegerArray transferToIntegerArray = new TransferToIntegerArray();
        try{
            //transferToIntegerArray.showOneDimArray(transferToIntegerArray.toOneDimArray(filePath + fileName));
            return transferToIntegerArray.toTwoDimArray(filePath + fileName);
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


}

