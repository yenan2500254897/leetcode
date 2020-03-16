package JZOffer;

import java.util.*;

public class EditWords {

    String editWords(String s){
        if(s.isEmpty()){
            return s;
        }

        int index = 0;
        StringBuilder stringBuilder = new StringBuilder(s);
        while (index<stringBuilder.length()){
            int len = stringBuilder.length();
            if (index+1<len && index+2<len && stringBuilder.charAt(index)==stringBuilder.charAt(index+1)
            && stringBuilder.charAt(index+1)==stringBuilder.charAt(index+2)){
                stringBuilder.deleteCharAt(index);
                continue;
            }
            if(index+1<len && index+2<len && index+3<len && stringBuilder.charAt(index)==stringBuilder.charAt(index+1)
            && stringBuilder.charAt(index+2)==stringBuilder.charAt(index+3)){
                stringBuilder.deleteCharAt(index+2);
                continue;
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        int n=0;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        Queue<String> list = new ArrayDeque<>(1);
        for(int i=1;i<=n;i++){
            list.add(scanner.next());
        }
        EditWords editWords = new EditWords();
        while(!list.isEmpty()){
            System.out.println(editWords.editWords(list.poll()));
        }
    }

}
