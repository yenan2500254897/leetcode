package JZOffer;

import java.util.*;

public class permutation {
    private Set<String> list;
    private StringBuilder builder;
    public String[] permutation(String s) {
        list = new HashSet<String>(4);
//
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        s=String.copyValueOf(chars);
        builder = new StringBuilder(s);
        swap(0, 0);
        return list.toArray(new String[0]);
    }

    private void swap(int start, int step){

        int len = builder.length();
        if(len == step){
            list.add(builder.toString());
            return;
        }
        for(int index = start;index<len;index++){

            char temp = builder.charAt(index);
            builder.setCharAt(index, builder.charAt(start));
            builder.setCharAt(start, temp);
            swap(start+1, step+1);
            temp = builder.charAt(index);
            builder.setCharAt(index, builder.charAt(start));
            builder.setCharAt(start, temp);
        }
    }
}
