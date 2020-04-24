package prepare;

public class TrailingZeroesAchieve {

    public int trailingZeroes(int n) {

        int total = 0;
        while (n!=0){
            total += n/5;
            n=n/5;
        }
        return total;
    }
}
