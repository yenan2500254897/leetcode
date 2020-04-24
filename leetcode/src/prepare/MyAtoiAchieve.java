package prepare;

public class MyAtoiAchieve {

    public int myAtoi(String str) {
        str = str.trim();

        if(str.isEmpty()){
            return 0;
        }

        char ch = str.charAt(0);
        //首字母不符合要求
        if(ch != '-' && ch != '+' && !(ch>='0' && ch<='9')){
            return 0;
        }

        //符号标识位
        boolean flag = false;
        if(ch == '-' || ch == '+'){
            if(ch == '-'){
                flag = true;
            }
            str = str.substring(1);
        }

        //判断符号位后是否为数字
        boolean hasNumber = false;
        boolean first = false;
        boolean second = true;
        int result = 1;
        while (!str.isEmpty() && str.charAt(0)>='0' && str.charAt(0)<='9'){
            //第一个数字
            if(hasNumber == false){
                //将字母与'0'的差值转换为整数
                result = Integer.valueOf(str.charAt(0)-'0');
            }else {
                //非第一个数字,判断是否溢出
                if(result>(Integer.MAX_VALUE-Integer.valueOf(str.charAt(0)-'0'))/10){
                    if(flag == true){
                        return Integer.MIN_VALUE;
                    }
                    return Integer.MAX_VALUE;
                }

                result = result*10 + Integer.valueOf(str.charAt(0)-'0');
            }
            hasNumber = true;
            str=str.substring(1);
        }

        //没有有效数字
        if(hasNumber == false){
            return 0;
        }

        //符号位为负数
        if(flag == true){
            result *= -1;
        }

        return result;
    }

    public static void main(String[] args){
        MyAtoiAchieve item = new MyAtoiAchieve();
        System.out.println(item.myAtoi("-91283472332"));
    }
}
