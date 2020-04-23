package prepare;

public class MaxProfitAchieve {
//    public int maxProfit(int[] prices) {
//
//        int count =0;
//        int len = prices.length;
//        //start表示买入的日期
//        int start = 0;
//        while (start<len){
//            //end表示卖出的日期
//            int end = len-1;
//            while (end>start){
//                if(prices[end]>prices[start]){
//                    int profit = prices[end]-prices[start];
//                    if(profit>count){
//                        count = profit;
//                    }
//                }
//                end--;
//            }
//            start++;
//        }
//        return count;
//
//    }

    public int maxProfit(int[] prices) {

        int count =0;
        int len = prices.length;

        if(len==0){
            return count;
        }

        //用来记录左边的最低股价
        int[] record =new int[len];
        record[0] = prices[0];
        int index = 1;
        while (index<len){
            //index的股价和index前的最低股价做差值，与count做比较
            if(prices[index] - record[index-1]>count){
                count = prices[index] - record[index-1];
            }
            record[index] = Math.min(record[index-1], prices[index]);
            index++;
        }
        return count;

    }
}
