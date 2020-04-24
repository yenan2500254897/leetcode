package prepare;

import java.util.Stack;

public class IsValidAchieve {

    public boolean isValid(String s) {
        if(s == null || s.isEmpty()){
            return true;
        }

        int len = s.length();

        Stack<Character> stack = new Stack<>();
        for(int index = 0;index<len;index++){
            char ch = s.charAt(index);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else {
                if(ch == ')' && (stack.isEmpty() || stack.pop()!='(')){
                    return false;
                }
                if(ch == '}' && (stack.isEmpty() || stack.pop()!='{')){
                    return false;
                }
                if(ch == ']' && (stack.isEmpty() || stack.pop()!='[')){
                    return false;
                }
            }
        }

        return stack.isEmpty()?true:false;
    }
}
