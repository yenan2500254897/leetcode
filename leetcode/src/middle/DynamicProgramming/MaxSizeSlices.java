package middle.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSizeSlices {

    private int[][] record;
    private boolean[][][] disabled;

    public int maxSizeSlices(int[] slices) {
        if(slices == null || slices.length == 0){
            return 0;
        }

        int n = slices.length;
        record = new int[n/3 + 1][n];
        disabled = new boolean[n/3 + 1][n][n];
        int len = slices.length;

        //层次
        for(int circle = 1;circle<=n/3;circle++){

            for(int index = 0;index<n;index++){

                int maxIndex = index;
                int left = -1;
                int right = -1;
                if(circle>1){
                    for(int sec=0;sec<n;sec++){
                        if(index != sec && disabled[circle-1][sec][index] == false ){
                            left = find(disabled[circle-1][sec], index, 1);
                            right = find(disabled[circle-1][sec], index, -1);
                            if(record[circle-1][sec] + slices[index]>=record[circle][index]) {
                                record[circle][index] = record[circle-1][sec] + slices[index];
                                maxIndex = sec;
                            }
                        }
                    }
                }else{
                    record[circle] = Arrays.copyOfRange(slices, 0, n);
                }

                left = find(disabled[circle-1][maxIndex], index, 1);
                right = find(disabled[circle-1][maxIndex], index, -1);

                disabled[circle][index] = Arrays.copyOfRange(disabled[circle-1][maxIndex],0, n);
                //disabled[circle][index] = disabled[circle-1][maxIndex];
                disabled[circle][index][index] = true;
                disabled[circle][index][left] = true;
                disabled[circle][index][right] = true;
            }
        }

        Arrays.sort(record[n/3]);

        return record[n/3][n-1];
    }

    public int find(boolean[] nums, int start, int dir){
        int len = nums.length;
        if(dir<0){
            int right = (start+dir+len)%len;
            while (nums[right] == true){
                right = (right+dir+len)%len;
            }
            return right;
        }
        int left = (start+dir)%len;
        while (nums[left] == true){
            left = (left+dir)%len;
        }
        return left;
    }


    //4 1 2 5 8 3 1 9 7
    //9 8 1 7 7 9 5 10 7 9 3 8 3 4 8 - 0 5 7 9 11

    public static void main(String[] args){
        int n =15;
        Scanner scanner = new Scanner(System.in);
        int[] inputs = new int[n];

        for(int i=0;i<n;i++){
            Integer item = scanner.nextInt();
            inputs[i] = item;
        }

        MaxSizeSlices maxSizeSlices = new MaxSizeSlices();
        System.out.println(maxSizeSlices.maxSizeSlices(inputs));
    }


}
