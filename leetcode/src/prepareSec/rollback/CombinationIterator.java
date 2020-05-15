package prepareSec.rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationIterator {

//    List<String> list = new ArrayList<>(4);
//    int index =0;
//
//    public CombinationIterator(String characters, int combinationLength) {
//        permute(characters, 0, combinationLength, "");
//    }
//
//    public String next() {
//        String result = list.get(index);
//        index++;
//        return result;
//    }
//
//    public boolean hasNext() {
//        return index<list.size()?true:false;
//    }
//
//    public void permute(String str, int index, int len, String pre){
//        if(index+len>str.length()){
//            return;
//        }
//
//        if(len == 0){
//            list.add(pre);
//            return;
//        }
//        permute(str, index+1, len-1, pre+str.charAt(index));
//        permute(str, index+1, len, pre);
//    }


    String str = "";
    Stack<Character> stack ;
    int len = 0;

    public CombinationIterator(String characters, int combinationLength) {
        stack =new Stack<Character>(){
            @Override
            public synchronized String toString() {
                String result = "";
                for(Character ch:stack){
                    result += ch;
                }
                return result;
            }
        };
        str = characters;
        len = combinationLength;
        for(int i=0;i<combinationLength;i++){
            stack.push(str.charAt(i));
        }
    }

    public String next() {
        String result = stack.toString();

        while (!stack.isEmpty()){
            Character ch = stack.pop();
            int index = str.indexOf(""+ch);
            if(str.length()-index-1 >= (len-stack.size())){
                int diff = len - stack.size();
                for(int i=1;i<=diff;i++){
                    stack.push(str.charAt(index+i));
                }
                break;
            }
        }
        return result;
    }

    public boolean hasNext() {
        return stack.isEmpty()?false:true;
    }



    public static void main(String[] args){
        CombinationIterator iterator = new CombinationIterator("abcd", 2); // 创建迭代器 iterator

        System.out.println(iterator.next()); // 返回 "ab"
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 "ac"
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 "bc"
        System.out.println(iterator.hasNext()); // 返回 false

        System.out.println(iterator.next()); // 返回 "ab"
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 "ac"
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 "bc"
        System.out.println(iterator.hasNext()); // 返回 false


    }
}
