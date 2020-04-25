package prepare;

import java.util.ArrayList;
import java.util.List;

public class GenerateAchieve {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(4);
        if(numRows<=2){
            for(int i=1;i<=numRows;i++){
                List<Integer> list = new ArrayList<>(4);
                for(int j=0;j<i;j++){
                    list.add(1);
                }
                lists.add(list);
            }
            return lists;
        }



        for(int i=1;i<=2;i++){
            List<Integer> list = new ArrayList<>(4);
            for(int j=0;j<i;j++){
                list.add(1);
            }
            lists.add(list);
        }
        for(int index =3;index<=numRows;index++){
            List<Integer> assistant = new ArrayList<>(index);
            List<Integer> pre = lists.get(index-2);
            for(int j=0;j<index;j++){
                if(j==0 || j==index-1){
                    assistant.add(1);
                }else{
                    assistant.add(pre.get(j-1)+pre.get(j));
                }
            }
            lists.add(assistant);
        }
        return lists;
    }

    public static void main(String[] args){
        GenerateAchieve item = new GenerateAchieve();
        item.generate(5);

        }

}
