package JZOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 * 解题思路：
 * 1.因为一个数组至少有两个数，所以循环次数最多为（target+1）/2
 * 2.如果i在某个数组中，则有两种情况：
 * （1）i为中位数
 * （2）（i+i+1）/2 为中位数
 *
 * 另外get到达point：
 * 如何将多维度的链表转换为多维度的数组（此处以二维为例）
 * 首先使用List<int[]>,最后使用toArray(T[] a)方法，但是需要指明维度
 */
public class findContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> result= new ArrayList<>();
        for(int i=1;i<=target/2;i++){
            if(target%i == 0 && (target/i)%2==1){
                int width = (target/i) /2;
                if(i-width > 0 && i+width<=target){
                    int[] oddList = new int[2*width+1];
                    for(int circle = i-width;circle<=i+width;circle++){
                        oddList[circle-i+width] = circle;
                    }
                    result.add(oddList);
                }
            }
            if(target % (2*i + 1) == 0){
                int secWidth = target / (2*i+1);
                if(i-secWidth+1>0 && i+secWidth<=target){
                    int[] evenList = new int[2*secWidth];
                    for(int circle = i-secWidth+1;circle<=i+secWidth;circle++){
                        evenList[circle-i+secWidth-1] = circle;
                    }
                    result.add(evenList);
                }
            }
        }

        return result.toArray(new int[0][]);
    }
}
