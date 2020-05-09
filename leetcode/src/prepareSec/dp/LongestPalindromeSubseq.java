package prepareSec.dp;

import prepare.LengthOfLISAchieve;

public class LongestPalindromeSubseq {



    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len<=1){
            return len;
        }

        //record[i][j]表示字符串第i位到第j位的最长回文子序列的长度
        int[][] record = new int[len+1][len];

        for(int i=0;i<len;i++){
            record[i][i] = 1;
        }

        //方向：从下往上，从左往右
        for(int left = len-1;left>=0;left--){
            for(int right = left+1;right<len;right++){


                //两边的字母相等
                if(s.charAt(left) == s.charAt(right)){
                    record[left][right]=record[left+1][right-1] + 2;
                }else {
                    //两边的字母不相等
                    record[left][right] = Math.max(record[left+1][right], record[left][right-1]);
                }
            }
        }
        return record[0][len-1];
    }

    public static void main(String[] args){
        LongestPalindromeSubseq longestPalindromeSubseq = new LongestPalindromeSubseq();
        System.out.println(longestPalindromeSubseq.longestPalindromeSubseq("babb"));
    }
}
