package prepare;

public class RemoveDuplicatesAchieve {

    public int removeDuplicates(int[] nums) {

        int len=nums.length;

        //表示前start+1个有序无重复数的最后一个index
        int start = 0;
        //游标
        int end = start+1;
        while (end<len){

            //一个区间里的数相等
            while (end<len && nums[start]==nums[end]){
                end++;
            }

            //碰到连续相等区间外的第一个元素,将在end上的元素交换到start上
            if(end<len){
                start++;
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end++;
            }
        }

        return start+1;
    }
}
