package prepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteAchieve {

    List<List<Integer>> lists =new ArrayList<>(4);
    public List<List<Integer>> permute(int[] nums) {
        find(nums, 0);
        return lists;
    }

    public void find(int[] nums, int index){
        int len = nums.length;
        if(index == len){
            Integer[] assitant =  Arrays.stream(nums).boxed().toArray(Integer[]::new);
            lists.add(Arrays.asList(assitant));
            return;
        }

        for(int i=index;i<len;i++){
            swap(nums, index, i);
            find(nums, index+1);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
