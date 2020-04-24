package prepare;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseAchieve {

    public int reverse(int x) {

        //默认为正
        boolean flag=true;

        if(x==0){
            return x;
        }

        //判断是否为负
        if(x<0){
            flag = false;
        }

        x = Math.abs(x);
        Queue<Integer> queue = new ArrayDeque<>(4);
        while (x!=0){
            queue.add(x%10);
            x = x/10;
        }

        //去除前面的0
        while (queue.peek() == 0){
            queue.poll();
        }

        long result = queue.poll();
        while (!queue.isEmpty()){
            result = result*10 + queue.poll();
        }

        if(flag == false){
            result *= -1;
        }

        return (result>Integer.MAX_VALUE || result<Integer.MIN_VALUE)?0:(int)result;
    }
}
