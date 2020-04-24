package prepare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiplyAchieve {
    public String multiply(String num1, String num2) {
        if(num1.length()<num2.length()){
            String tempStr = num1;
            num1 = num2;
            num2 = tempStr;
        }


        //记录进位
        int carrier = 0;
        int len = num2.length();


        int index = 0;
        List<List<Integer>> lists = new ArrayList<>(4);
        while (index<len){


            List<Integer> list = new LinkedList<>();
            //补上0
            for(int i=0;i<index;i++){
                list.add(0);
            }

            //选出num2的一位与num1做乘法
            int number = Integer.valueOf(num2.charAt(len-index-1)-'0');
            int anotherLen = num1.length();
            for(int j=0;j<anotherLen;j++){
                int multiplyValue = number*Integer.valueOf(num1.charAt(anotherLen-j-1)-'0')+carrier;
                int remainder = multiplyValue%10;
                carrier = multiplyValue/10;
                list.add(remainder);
            }
            //判断是否有进位
            if(carrier!=0){
                list.add(carrier);
                carrier = 0;
            }
            lists.add(list);
            index++;
        }

        carrier = 0;
        for(index=0;index<lists.size();index++){
            if(index+1<lists.size()){
                List<Integer> preList = lists.get(index);
                List<Integer> nextList = lists.get(index+1);

                for(int i=0;i<nextList.size();i++){
                    if(i<preList.size()){
                        int total = preList.get(i) + nextList.get(i) + carrier;
                        nextList.set(i, total%10);
                        carrier = total/10;
                    }else {
                        int anotherTotal = nextList.get(i) + carrier;
                        nextList.set(i, anotherTotal%10);
                        carrier = anotherTotal/10;
                    }
                }

                if(carrier!=0){
                    nextList.add(carrier);
                    carrier = 0;
                }
            }
        }

        List<Integer> retList = lists.get(lists.size()-1);
        int lastIndex = retList.size()-1;
        StringBuilder retStr = new StringBuilder(4);
        while (lastIndex>=0){
            retStr.append(retList.get(lastIndex));
            lastIndex--;
        }
        if(retStr.charAt(0) == '0'){
            return "0";
        }
        return retStr.toString();
    }

    public static void main(String[] args){
        MultiplyAchieve item = new MultiplyAchieve();
        System.out.println(item.multiply("12", "12"));
    }
}
