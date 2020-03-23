package JZOffer;

public class Exchange {

    //[1,2,3,4]
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length<=1){
            return nums;
        }

        int head = 0;
        int tail = nums.length-1;

        while (head<tail){
            if(nums[head]%2==1){
                head++;
                continue;
            }
            if(nums[tail]%2==0){
                tail--;
            }
            if(head>=tail){
                break;
            }
            int temp=nums[head];
            nums[head]=nums[tail];
            nums[tail]=temp;
        }
        return nums;
    }
}
