package middle;

import java.util.Stack;

/**
 * 1209. 删除字符串中的所有相邻重复项 II
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 *
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 *
 * 在执行完所有删除操作后，返回最终得到的字符串。
 *
 * 本题答案保证唯一。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 * 示例 2：
 *
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 * 示例 3：
 *
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s 中只含有小写英文字母。
 *
 */
public class removeDuplicates {

    public String removeDuplicates(String s, int k) {
        Stack<Character> characters = new Stack<Character>();
        Stack<Integer> count = new Stack<Integer>();

        int len = s.length();
        for(int i=0;i<len;i++){
            if(characters.isEmpty() || s.charAt(i)!=characters.peek()){
                characters.push(s.charAt(i));
                count.push(1);
            }else {
                if(count.peek()==k-1){
                    count.pop();
                    characters.pop();
                }else {
                    count.push(count.pop()+1);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!characters.isEmpty()){
            int len1 = count.pop();
            Character ch = characters.pop();
            for(int i = 0;i<len1;i++){
                stringBuilder.insert(0, ch);
            }
        }
        return stringBuilder.toString();
    }
//    public String removeDuplicates(String s, int k) {
//        Stack<Character> stack = new Stack<Character>();
//        int finish = s.length();
//        for(int index = 0;index<finish;index++){
//            stack.push(s.charAt(index));
//            if(stack.size()>=k){
//                int len = stack.size();
//                if(check(stack, k)){
//                    int temp = k;
//                    while(temp>0){
//                        stack.pop();
//                        temp--;
//                    }
//                }
//            }
//        }
//        StringBuilder result = new StringBuilder();
//        while(!stack.empty()){
//            result.append(stack.pop());
//        }
//        return result.reverse().toString();
//    }
//
//    boolean check(Stack<Character> stack, int k){
//        boolean result = true;
//        int len = stack.size();
//        for(int i=1;i<k;i++){
//            result &= (stack.elementAt(len -i) == stack.elementAt(len-i-1));
//        }
//        return result;
//    }
}
