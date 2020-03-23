package JZOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class replaceSpace {

    public String replaceSpace(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        int length = s.length();
        for(int i=0;i<length;i++){
            if(s.charAt(i)==' '){
                queue.add('%');
                queue.add('2');
                queue.add('0');
            }else{
                queue.add(s.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!queue.isEmpty()){
            stringBuilder.append(queue.peek());
            queue.poll();
        }
        return stringBuilder.toString();
    }

    public String secReplaceSpace(String s) {
        s.replaceAll(" ", "%20");
        return s;
    }
}
