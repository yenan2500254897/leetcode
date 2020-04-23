package prepare;

public class MinSubArrayLenAchieve {

    public int minSubArrayLen(int s, int[] nums) {

        int result = 0;
        int len = nums.length;

        int start = 0;
        int end = 0;

        int total = 0;

        while (end<=len && start<=end){
            if(total<s && end==len){
                break;
            }

            //total<s且end<len时，右移end
            if(total<s && end<len){
                total+=nums[end];
                end++;
                continue;
            }

            //total>s的情况
            if(total>=s){
                if(result==0){
                    result = end-start;
                }else {
                    result = Math.min(result, end-start);
                }
                total -= nums[start];
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] arrays = {1,2,3,4,5};
        MinSubArrayLenAchieve item = new MinSubArrayLenAchieve();
        System.out.println(item.minSubArrayLen(11, arrays));
    }
}
