package prepareSec.rollback;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {

    List<String> list = new ArrayList<>(4);
    int index =0;

    public CombinationIterator(String characters, int combinationLength) {
        permute(characters, 0, combinationLength, "");
    }

    public String next() {
        String result = list.get(index);
        index++;
        return result;
    }

    public boolean hasNext() {
        return index<list.size()?true:false;
    }

    public void permute(String str, int index, int len, String pre){
        if(index+len>str.length()){
            return;
        }

        if(len == 0){
            list.add(pre);
            return;
        }
        permute(str, index+1, len-1, pre+str.charAt(index));
        permute(str, index+1, len, pre);
    }

    public static void main(String[] args){
        CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 iterator

        System.out.println(iterator.next()); // 返回 "ab"
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 "ac"
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 "bc"
        System.out.println(iterator.hasNext()); // 返回 false


    }
}
