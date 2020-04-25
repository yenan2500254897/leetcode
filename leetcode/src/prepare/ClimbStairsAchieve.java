package prepare;

public class ClimbStairsAchieve {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }

        int[] result = new int[n];

        result[1] = 1;
        result[2] = 2;
        for(int i=3;i<n;i++){
            result[i] = result[i-1]+result[i-2];
        }
        return result[n-1];
    }
}
