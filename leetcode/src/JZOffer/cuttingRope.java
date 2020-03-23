package JZOffer;

public class cuttingRope {
    public int cuttingRope(int n) {
        if(n<2){
            return 0;
        }
        int[] record=new int[n+1];
        record[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                int first = Math.max(j, record[j]);
                int second = Math.max(i-j, record[i-j]);
                if(first*second > record[i]){
                    record[i] = first*second;
                }
            }
        }
        return record[n];
    }

    public int secCuttingRope(int n) {
        if(n<=3){
            return n-1;
        }
        long result = 1;
        while (n>0){
            if(n/3>0){
                if(n!=4){
                    result = result * 3;
                    n-=3;
                }else {
                    result = result * 4;
                    n-=4;
                }
                continue;
            }
            result = result*n;
            break;
        }
        return (int)(result%(1000000007));
    }
}
