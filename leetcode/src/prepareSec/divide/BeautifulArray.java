package prepareSec.divide;

import java.util.Arrays;

public class BeautifulArray {

    public int[] beautifulArray(int N) {
        int[] input = new int[N];
        for(int i=0;i<N;i++){
            input[i] = i+1;
        }
        arrange(input);
        return input;
    }

    private int[] arrange(int[] input){
        int len = input.length;
        if(len==1){
            return input;
        }

        //奇数索引的数组
        int[] odd = new int[(len/2)];
        //偶数索引的数组
        int[] even = new int[(len+1)/2];

        for(int i=0;i<len;i++){
            if(i%2==0){
                even[i/2] = input[i];
            }else {
                odd[i/2] = input[i];
            }
        }
        arrange(even);
        arrange(odd);

        for(int i=0;i<len;i++){
            if(i<odd.length){
                input[i] = odd[i];
            }else {
                input[i] = even[i-odd.length];
            }
        }
        return input;
    }


    public static void main(String[] args){
        BeautifulArray beautifulArray = new BeautifulArray();
        int[] test  = beautifulArray.beautifulArray(5);
        int i=0;
        for(;i<test.length-2;i++){
            if(test[i+1]*2 == test[i]+test[i+2]){
                break;
            }
        }
        System.out.println("i = " + i );
    }
}
