package middle.DynamicProgramming;

import utils.TransferToIntegerArray;

import javax.swing.*;

/**
 * 1223. 掷骰子模拟
 * 有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。
 *
 * 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。
 *
 * 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。
 *
 * 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2, rollMax = [1,1,2,2,2,3]
 * 输出：34
 * 解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
 * 示例 2：
 *
 * 输入：n = 2, rollMax = [1,1,1,1,1,1]
 * 输出：30
 * 示例 3：
 *
 * 输入：n = 3, rollMax = [1,1,1,2,2,3]
 * 输出：181
 *  
 *
 * 提示：
 *
 * 1 <= n <= 5000
 * rollMax.length == 6
 * 1 <= rollMax[i] <= 15
 *

 */
public class DieSimulator {

    public static long remainder= 1000000007L;
    public static int n=3;
    public static final String filePath = "C:\\Users\\yn\\IdeaProjects\\leetcode\\leetcode\\";
    public static final String fileName = "test.txt";

    public int dieSimulator(int n, int[] rollMax) {
        TransferToIntegerArray transferToIntegerArray = new TransferToIntegerArray();
        int len = rollMax.length;
        long[][] result = new long[n+1][len];
        //transferToIntegerArray.showOneDimArray(rollMax);

        //初始化，第 1 行
        for(int index = 0;index<len;index++){
            if(rollMax[index] > 0){
                result[1][index] = 1;
            }
        }

        //遍历行
        for(int index =2;index<=n;index++){
            for(int cursor =0;cursor<len;cursor++){
                if((index-1)%rollMax[cursor] == 0){
                    result[index][cursor] = calValue(result, index -1, cursor) + calValue(result, index%rollMax[cursor] ,cursor);
                }else {
                    result[index][cursor] = calValue(result, index -1, -1);
                }
            }

        }
        transferToIntegerArray.showTwoDimArray(result);

        long returnValue = calValue(result, n, -1);
        return (int) (returnValue % remainder);
    }

    public long calValue(long[][] result, int index, int cursor){
        if(index<0){
            return 0;
        }
        long total =0;
        for(int i=0;i<result[0].length;i++){
            if(i!=cursor){
                total += result[index][i];
            }
        }
        return total;
    }

    public static void main(String[] args) throws Exception{
        TransferToIntegerArray transferToIntegerArray = new TransferToIntegerArray();
        int[] input = transferToIntegerArray.toOneDimArray(filePath+fileName);
        DieSimulator dieSimulator = new DieSimulator();
        System.out.println(dieSimulator.dieSimulator(n,input));
    }
}
