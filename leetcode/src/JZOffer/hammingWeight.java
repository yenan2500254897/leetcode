package JZOffer;

public class hammingWeight {

    public int hammingWeight(int n) {
        int oneCount =0;
        while (n!=0){
            n=n&(n-1);
            oneCount++;
        }
        return oneCount;
    }
}
