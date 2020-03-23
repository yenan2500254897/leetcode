package src.middleSec;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Poker {

    private int putPokerCount = 0;

    private Map<Integer, Integer> map;

    public int findMinPutCount(int[] inputs){
        int len = inputs.length;
        map = new HashMap<Integer, Integer>(10);
        for(int i=0;i<len;i++){
            map.put(i, inputs[i]);

        }
        find(0,0);
        return putPokerCount;
    }

    private void find(int start, int step){
        if(start == map.size()){
            if(putPokerCount == 0 || putPokerCount>step){
                putPokerCount = step;
            }
            return;
        }

        if(map.get(start) == 0){
            find(start+1, step);
            return;
        }else {
            int len = map.size();
            //三连对
            if(start+1 < len && start+2 < len && map.get(start)>=2 && map.get(start+1)>=2 && map.get(start+2)>=2){
                dealWith(start, start+2, -2);
                find(start, step+1);
                dealWith(start, start+2, 2);
            }

            //顺子
            if(start+1 < len && start+2 < len && start+3 < len && start+4 < len
                    && map.get(start)>=1 && map.get(start+1)>=1 && map.get(start+2)>=1 && map.get(start+3)>=1
            && map.get(start+4)>=1){
                dealWith(start, start+4,-1);
                find(start, step+1);
                dealWith(start, start+4,1);
            }

            //两对
            if(start+1 < len && map.get(start)>=2 && map.get(start+1)>=2){
                dealWith(start, start+1, -2);
                find(start, step+1);
                dealWith(start, start+1,2);
            }

            dealWith(start,start,-1);
            find(start, step+1);
            dealWith(start, start,1);
        }


    }

    private void dealWith(int start, int end, int value){
        for(int index=start;index<=end;index++){
            map.put(index, map.get(index)+value);
        }
    }


    public static void main(String[] args){
        int n=10;
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            Integer item = scanner.nextInt();
            nums[i] = item;
        }
        Poker poker = new Poker();
        System.out.println(poker.findMinPutCount(nums));
    }
}
