package prepare;

import java.util.*;

public class RemoveDuplicateLettersAchieve {


//    private List<String> list;
//    public String removeDuplicateLetters(String s) {
//
//        int len = s.length();
//        Set<Character> set = new HashSet<>();
//        for(int i=0;i<len;i++){
//            set.add(s.charAt(i));
//        }
//        list = new ArrayList<String>();
//        String target = "";
//        findAllChars(s, 0, set, target);
//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        return list.get(0);
//
//    }
//
//    public void findAllChars(String s, int index, Set<Character> set, String target){
//        if(set.isEmpty()){
//            list.add(target);
//            return;
//        }
//
//        if(index>=s.length()){
//            return;
//        }
//
//        char ch = s.charAt(index);
//        if(set.contains(ch)){
//            set.remove(ch);
//
//            findAllChars(s, index+1, set, target+String.valueOf(ch));
//
//            set.add(ch);
//            findAllChars(s,index+1, set, target);
//        }else {
//            findAllChars(s, index+1, set, target);
//        }
//    }

    public String removeDuplicateLetters(String s) {
        if(s.isEmpty()){
            return "";
        }
        int len = s.length();
        if(len == 1){
            return s;
        }

        int[] count = new int[26];
        for(int i=0;i<len;i++){
            count[s.charAt(i)-'a'] += 1;
        }

        int pos = 0;

        for(int i=0;i<len;i++){
            if(s.charAt(i)<s.charAt(pos)){
                pos = i;
            }
            if(--count[s.charAt(i)-'a'] == 0){
                break;
            }
        }

        return s.charAt(pos)+ removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos),""));
    }

    public static void main(String[] args){
        RemoveDuplicateLettersAchieve item = new RemoveDuplicateLettersAchieve();
        System.out.println(item.removeDuplicateLetters("cbacdcbc"));
    }
}
