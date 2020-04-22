package prepare;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class LengthOfLongestSubstringAchieve {

    //华东区窗口可以用队列实现
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();

        Queue<Character> queue = new ArrayDeque<Character>(4);

        int maxValue=-1;
        for(int index = 0;index<len;index++){
            //无重复，往queue中加元素
            if(queue.isEmpty() || !queue.contains(s.charAt(index))){
                queue.add(s.charAt(index));
                continue;
            }
            //找到重复值，更新长度
            if(maxValue==-1 || maxValue<queue.size()){
                maxValue = queue.size();
            }
            //从queue中弹出值
            while(queue.poll()!=s.charAt(index)){

            }
            //往queue中放入值
            queue.add(s.charAt(index));
        }
        //比较queue中剩下元素的长度是否大于maxValue
        maxValue = Math.max(maxValue, queue.size());
        return maxValue;

    }
}
