package prepare;

public class LongestCommonSubsequenceAchieve {

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.isEmpty() || text2.isEmpty()){
            return 0;
        }

        if(text1.length()>text2.length()){
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int row = text1.length();
        int col = text2.length();

        int[][] record = new int[row+1][col+1];

        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    record[i][j] = record[i-1][j-1]+1;
                }else {
                    record[i][j] = Math.max(record[i-1][j], record[i][j-1]);
                }
            }
        }
        return record[row][col];
    }


}
