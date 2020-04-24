package prepare;

import java.util.Stack;

public class MinStackAchieve {

    private Stack<Integer> stack;
    private Stack<Integer> assistant;
    public MinStackAchieve() {
        stack = new Stack<>();
        assistant = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        //assistant 为空，直接将x 压入栈
        if(assistant.isEmpty()){
            assistant.push(x);
        }else {
            //不为空时，将x和栈顶元素中的较小值压入栈
            assistant.push(Math.min(x, assistant.peek()));
        }

    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            assistant.pop();
        }
    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        if(!assistant.isEmpty()){
            return assistant.peek();
        }
        return -1;
    }
}
