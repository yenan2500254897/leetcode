package prepare;

import java.util.Stack;

public class LongestValidParenthesesAchieve {


    public int longestValidParentheses(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }

        //记录左括号的索引
        Stack<Integer> recordLeftBracket = new Stack<>();
        //记录括号是否匹配
        int len = s.length();
        boolean[] valid = new boolean[len];

        //遍历字符串
        char ch = ' ';
        for(int i=0;i<len;i++){
            ch = s.charAt(i);
            //将左括号的索引存入栈
            if(ch == '('){
                recordLeftBracket.push(i);
            }else{
                //遇到右括号，则弹出左括号
                if(!recordLeftBracket.isEmpty()){
                    int matchIndex = recordLeftBracket.pop();
                    //标记对应位置的左括号为有效匹配
                    valid[matchIndex] = true;
                    //标记对应位置的右括号为有效匹配
                    valid[i] = true;
                }
            }
        }

        int maxValidLength = 0;

        //遍历valid找到最长的连续true的长度
        for(int index =0;index<len;index++){

            //碰到一个true
            if(valid[index]){
                int start = index;
                //取连续的true，知道碰到false或者遍历完
                while (index<len && valid[index] == true){
                    index++;
                }
                //更新最长有效括号长度
                maxValidLength = Math.max(maxValidLength, index-start);
            }
        }
        return maxValidLength;
    }
}
