package JZOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class myPow {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        int exponent = Math.abs(n);
        double result = 1.0;
        result *= myPow(x,exponent/2);
        result = result*result;
        if(exponent%2==1){
            result*=x;
        }
        if(n<0){
            return 1/result;
        }
        return result;

    }

    public static void main(String[] args){
        myPow t = new myPow();
        System.out.println(t.myPow(2.0,10));
    }
}
