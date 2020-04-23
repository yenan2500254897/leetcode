package prepare;

public class TrapAchieve {

    public int trap(int[] height) {
        int len = height.length;

        //表示左边的最高的柱子的高度
        int[] left = new int[len];
        //表示右边的最高的柱子的高度
        int[] right = new int[len];

        int circle = 1;
        while (circle<len-1){
            //最左、最右
            if(circle==1){
                left[circle] = height[circle-1];
                right[len-circle-1 ] = height[len-circle];
            }else {
                //left[circle-1]表示circle-1左边的最高的柱子的高度（不含circle-1）
                left[circle] = Math.max(left[circle-1], height[circle-1]);
                //right[len-circle]表示len-circle右边的最高的柱子的高度（不含len-circle）
                right[len-circle-1] = Math.max(right[len-circle], height[len-circle]);
            }
            circle++;

        }

        int total = 0;

        for(int index=1;index<len-1;index++){
            int heightValue = Math.min(left[index], right[index]);
            if(heightValue>height[index]){
                total+=(heightValue-height[index]);
            }
        }
        return total;
    }

    public static void main(String[] args){
        TrapAchieve item = new TrapAchieve();

        int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        item.trap(array);
    }
}
