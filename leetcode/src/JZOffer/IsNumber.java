package JZOffer;

/**
 * 面试题20. 表示数值的字符串
 *
 * [+/-A].[B][e/E+/-C]
 */
public class IsNumber {
    private int index=0;
    public boolean isNumber(String s) {
        if(s== null || s.length()==0){
            return false;
        }
        s = s.trim();
        if(s.isEmpty()){
            return false;
        }
        //扫描+/-A
        if(s.charAt(0)=='+'||s.charAt(0)=='-'){
            index++;

        }
        boolean flagA = isInteger(s);
        //扫描.B
        if(index<s.length() && s.charAt(index)=='.'){
            index++;

        }
        boolean flagB= isInteger(s);
        boolean flagC = false;
        if(index<s.length() && (s.charAt(index)=='e'||s.charAt(index)=='E')){
            index++;
            if(index<s.length() && (s.charAt(index)=='+'||s.charAt(index)=='-')){
                index++;
            }
            flagC = isInteger(s);
            if(!flagC){
                return false;
            }
        }
        return index==s.length() && (flagA || flagB);
    }

    public boolean isInteger(String s){
        int len = s.length();
        int i=index;
        for(;index<len;index++){
            if(!(s.charAt(index)>='0' && s.charAt(index)<='9')){
                break;
            }
        }
        return i<index;
    }

    public static void main(String[] args){
        IsNumber isNumber=new IsNumber();
        System.out.println(isNumber.isNumber("2e0"));
    }

}
