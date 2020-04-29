package prepareSec.slidingwindows;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class TotalFruitAchieve {
    public int totalFruit(int[] tree) {

        //记录水果种类
        int fruitkind = 0;
        //记录水果数量的队列
        Queue<Integer> queue = new ArrayDeque<Integer>(4);

        int len=tree.length;
        int pre = 0;

        int maxValue = 0;
        while (pre<len){

            //没满两种水果的限制
            if(fruitkind < 2){

                //增加水果种类
                if(queue.isEmpty() || !queue.contains(tree[pre])){
                    fruitkind++;
                }

                //放入水果
                queue.add(tree[pre]);
            }else {
                if(fruitkind == 2){
                    //水果种类满2了，但是当前水果在之前的水果种类里
                    if(queue.contains(tree[pre])){
                        queue.add(tree[pre]);
                    }else {
                        //弹出至少一种种类水果，然后加入另一种种类水果
                        maxValue = Math.max(maxValue, queue.size());
                        int head = queue.poll();
                        while (!queue.isEmpty() && queue.contains(head)){
                            head = queue.poll();

                        }
                        queue.add(tree[pre]);

                    }
                }
            }
            pre++;
        }

        maxValue = Math.max(maxValue, queue.size());
        return maxValue;
    }
}
