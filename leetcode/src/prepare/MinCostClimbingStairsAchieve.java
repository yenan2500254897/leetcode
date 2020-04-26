package prepare;

public class MinCostClimbingStairsAchieve {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if(len<2){
            return 0;
        }

        if(len==2){
            return Math.min(cost[0], cost[1]);
        }

        int[] record = new int[len+1];
        record[0] = cost[0];
        record[1] = cost[1];

        for(int i=2;i<=len;i++){
            if (i == len) {
                record[i] = Math.min(record[i-1], record[i-2]);
            }else {
                record[i] = Math.min(record[i-1], record[i-2]) + cost[i];
            }
        }
        return record[len];
    }
}
