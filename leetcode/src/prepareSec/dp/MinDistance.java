package prepareSec.dp;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class MinDistance {

//    public int minDistance(String word1, String word2) {
//
//        return find(word1, word2, 0, 0, 0);
//    }
//
//    private int find(String word1, String word2, int index1, int index2, int currentStep){
//        if(currentStep>word2.length()){
//            return word2.length();
//        }
//
//        if(index1 == word1.length() && index2 == word2.length()){
//            return currentStep;
//        }
//
//        if(index1 == word1.length() || index2 == word2.length()){
//            return index1 == word1.length()?currentStep+word2.length()-index2:currentStep+word1.length()-index1;
//        }
//
//
//        int insertValue = find(word1.substring(0, index1)+word2.charAt(index2)+word1.substring(index1), word2, index1, index2, currentStep+1);
//        int delValue = find(word1.substring(0,index1) + word1.substring(index1+1), word2, index1, index2,currentStep+1);
//        int replaceValue = find(word1.substring(0,index1) + word2.charAt(index2) + word1.substring(index1+1), word2, index1+1, index2+1, currentStep+1);
//
//        int result = Math.min(insertValue, Math.min(delValue, replaceValue));
//
//        if(word1.charAt(index1) == word2.charAt(index2)){
//            int jumpValue = find(word1, word2, index1+1, index2+1, currentStep);
//            result = Math.min(result, jumpValue);
//        }
//        return result;
//    }

    public int minDistance(String word1, String word2) {

        int len1= word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];


        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0 || j==0){
                    dp[i][j] = (i==0?j:i);
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1)));
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args){
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance("prosperity", "properties"));
    }
}
