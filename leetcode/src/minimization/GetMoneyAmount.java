package minimization;

public class GetMoneyAmount {
    private int[][] record;
    public int getMoneyAmount(int n) {
        record = new int[n+1][n+1];
        return find(1, n);
    }

    public int find(int left, int right){

        if(left>=right){
            return 0;
        }

        if(left+1 == right){
            record[left][right] = left;
            return left;
        }

        if(record[left][right]!=0){
            return record[left][right];
        }

        int result = Integer.MAX_VALUE;

        for(int i=left;i<=right;i++){
            int middle = i;
            int temp = middle + Math.max(find(left, middle-1), find(middle+1, right));
            if(temp<result){
                result = temp;
            }
        }
        record[left][right] = result;
        return result;
    }

    public static void main(String[] args){
        GetMoneyAmount getMoneyAmount = new GetMoneyAmount();
        System.out.println(getMoneyAmount.getMoneyAmount(30));
    }
}
