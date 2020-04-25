package prepare;

public class LongestPalindromeAchieve {
    public String longestPalindrome(String s) {
        int len = s.length();

        String str = "";
        int start = 0;
        int end=0;
        for(int i=0;i<len;i++){
             start = i;
             end = i;

             while (start>=0 && end<len){
                 if(s.charAt(start) != s.charAt(end)){
                     break;
                 }
                 start--;
                 end++;
             }

             String tempStr = s.substring(start+1, end);
             if(tempStr.length()>str.length()){
                 str = tempStr;
             }

             start = i;
             end = i+1;
             while (start>=0 && end<len){
                 if(s.charAt(start) != s.charAt(end)){
                     break;
                 }
                 start--;
                 end++;
             }
            tempStr = s.substring(start+1, end);
            if(tempStr.length()>str.length()){
                str = tempStr;
            }
        }
        return str;

    }
}
