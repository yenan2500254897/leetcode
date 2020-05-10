package prepareSec.dp;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        int len = stones.length;
        if(len == 0){
            return 0;
        }

        if(len == 1){
            return stones[0];
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int stoneWeight:stones){
            priorityQueue.add(stoneWeight);
        }


        while (priorityQueue.size()>1){
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            priorityQueue.add(first-second);
        }

        return priorityQueue.poll();
    }

    public static void main(String[] args){
        int[] test = {2,7,4,1,8,1};
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(test));
    }
}
