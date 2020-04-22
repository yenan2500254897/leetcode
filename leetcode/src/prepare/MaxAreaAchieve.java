package prepare;

public class MaxAreaAchieve {

    public int maxArea(int[] height) {
        //双指针
        int start = 0;
        int end = height.length-1;
        int result = -1;

        while (start<end){
           int heightValue = Math.min(height[start], height[end]);
           int multiplyValue = heightValue*(end-start);
           if(result == -1 || multiplyValue>result){
               result = multiplyValue;
           }

           //左节点较矮
           if(heightValue == height[start]){
               start++;
           }else{
               //右节点较矮
               end--;
           }
        }
        return result;
    }
}
