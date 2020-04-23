package prepare;

import java.util.ArrayList;
import java.util.List;

public class ConvertAchieve {

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        int len = s.length();

        int index = 0;
        int specilaNum = numRows*2-2;
        List<List<Character>> lists = new ArrayList<>(numRows);
        for(int i=0;i<numRows;i++){
            List<Character> list = new ArrayList<>();
            lists.add(list);
        }

        while (index<len){

            int remainder = index%specilaNum;
            //取余小于等于numRows-1时，向下
            if(remainder <= numRows-1){
                lists.get(remainder).add(s.charAt(index));
            }

            //取余大于numRows-1时，向右上
            if(remainder > numRows-1){
                int temp = numRows - (remainder%numRows) -2;
                lists.get(temp).add(s.charAt(index));
            }

            index++;
        }

        String result = "";
        for(int i=0;i<numRows;i++){
            int circle = lists.get(i).size();
            for(int j=0;j<circle;j++){
                result += lists.get(i).get(j);
            }
        }
        return result;
    }
}
