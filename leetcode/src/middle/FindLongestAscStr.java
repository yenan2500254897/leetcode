package middleSec;

//ab abc bcd

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindLongestAscStr {

    private int[] result;

    public int findLongestAscStr(String[] str){
        List<String> list = Arrays.asList(str);
        result = new int[26];
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(o1.length()-1)==o2.charAt(o2.length()-1)){
                    return o1.substring(0,1).compareTo(o2.substring(0,1));
                }
                return o1.substring(o1.length()-1,o1.length()).compareTo(o2.substring(o2.length()-1, o2.length()));
            }
        });

        //Integer[] records = new Integer[26];
        int len = str.length;
        for(int i=0;i<len;i++){
            String tempStr = list.get(i);
            char first = tempStr.charAt(0);
            char last = tempStr.charAt(tempStr.length()-1);
            int pre = location(first);
            int temp = last - 'a';
            result[temp] = Math.max(result[temp], pre+ tempStr.length());

        }
        return location('z');

    }

    private int location(char ch){

        for(int index = ch-'a';index>=0;index--){
            if(result[index]!=0){
                return result[index];
            }
        }
        return 0;
    }

    public static void main(String[] args){
        FindLongestAscStr findLongestAscStr = new FindLongestAscStr();
        //String[] input = {"ab", "abc", "bcd"};
        String[] input = {"ab", "bcdfghi", "cdef"};
        System.out.println(findLongestAscStr.findLongestAscStr(input));
    }
}
