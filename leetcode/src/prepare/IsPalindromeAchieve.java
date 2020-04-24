package prepare;

public class IsPalindromeAchieve {
    public boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }
        if(x==0){
            return true;
        }

        int reverseValue = 0;
        boolean flag = false;
        int saveValue = x;
        while (x!=0){
            if(flag == false){
                reverseValue = x%10;
            }else {
                reverseValue = reverseValue*10+x%10;
            }
            x = x/10;
            flag = true;
        }

        return reverseValue == saveValue? true:false;
    }
}
