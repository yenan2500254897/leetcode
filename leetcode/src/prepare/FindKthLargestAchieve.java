package prepare;

public class FindKthLargestAchieve {

    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        if(k<=0 || k>len || len==0){
            return 0;
        }

        for(int i=0;i<len;i++){
            adjustHeap(nums, 0, len-i-1);
        }
        return nums[len-k];
    }

    public void adjustHeap(int[] array, int start, int end){
        if(start==end){
            return;
        }
        for(int i=(end-1)/2;i>=start;i--){
            int left =2*i+1;
            int right = left+1;

            if(right<=end && array[right]>array[left]){
                left=right;
            }

            if(array[i]<array[left]){
                int temp = array[i];
                array[i] = array[left];
                array[left] = temp;
            }
        }
        int assistant = array[start];
        array[start] = array[end];
        array[end] = assistant;
        return ;
    }
}
