package prepare;

public class LongestCommonPrefixAchieve {

    public String longestCommonPrefix(String[] strs) {

        int len = strs.length;
        if (len==0){
            return "";
        }

        String prefix = strs[0];

        for(int index = 1;index<len;index++){
            while (strs[index].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);
            }
            if(prefix.isEmpty()){
                return "";
            }
        }

        return prefix;
    }
}
