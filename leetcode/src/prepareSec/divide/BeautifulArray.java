package prepareSec.divide;

import java.util.Arrays;

public class BeautifulArray {

    public int[] beautifulArray(int N) {

        return find(N, 0);


    }

    private int[] find(int N, int iter){

        int[] result = new int[N];
        if(N == 0){
            return result;
        }

        if(N == 1){
            result[0] = 1;
            return result;
        }

        if(N<=2){

                result[0] = 1;
                result[1] = 2;

            return result;
        }

        if(iter%2==0){
            result[0] = N-2;
            result[N-2] = N;
            result[N-1] = N-1;

        }else {
            result[0] = N-1;
            result[N-2] = N;
            result[N-1] = N-2;
        }

        int[] middle = find(N-3, iter+1);
        for(int i=1;i<N-2;i++){
            result[i] = middle[i-1];
        }
        return result;

    }

    public static void main(String[] args){
        BeautifulArray beautifulArray = new BeautifulArray();
        int[] test  = beautifulArray.beautifulArray(100);
        int i=0;
        for(;i<test.length-2;i++){
            if(test[i+1]*2 == test[i]+test[i+2]){
                break;
            }
        }
        System.out.println("i = " + i );
    }
}
