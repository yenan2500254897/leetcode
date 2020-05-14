package prepareSec.dp;

import java.util.Arrays;

public class MinSwap {

    public int minSwap(int[] A, int[] B) {

        int len = A.length;

        if(len<=1){
            return 0;
        }

        int noswap = 0;
        int swap=1;

        for(int i=1;i<len;i++){
            int noswap1 = Integer.MAX_VALUE;
            int swap1 = Integer.MAX_VALUE;
            if(A[i]>A[i-1] && B[i]>B[i-1]){
                noswap1 = noswap;
                swap1 = swap+1;
            }

            int noswap2 = Integer.MAX_VALUE;
            int swap2 = Integer.MAX_VALUE;
            if(A[i]>B[i-1] && B[i]>A[i-1]){
                noswap2 = swap;
                swap2 = noswap+1;
            }

            swap = Math.min(swap1, swap2);
            noswap = Math.min(noswap1, noswap2);
        }
        return Math.min(swap, noswap);
    }



    public static void main(String[] args){
        MinSwap minSwap = new MinSwap();
        int[] A = {1,3,5,4};

        int[] B = {1,2,3,7};
        System.out.println(minSwap.minSwap(A, B));
    }
}
