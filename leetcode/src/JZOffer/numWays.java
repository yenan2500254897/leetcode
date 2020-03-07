package JZOffer;

public class numWays {

    public int numWays(int n) {
        if(n<=1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] result = new int[n+1];
        result[0]=1;
        result[1]=1;
        result[2]=2;
        for(int i=3;i<=n;i++){
            result[i]=(result[i-1]+result[i-2])%1000000007;
        }
        return result[n];
    }
}
