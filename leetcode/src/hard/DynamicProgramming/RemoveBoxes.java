package hard.DynamicProgramming;

/**
 * 564.移除盒子
 * 给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
 * 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
 * 当你将所有盒子都去掉之后，求你能获得的最大积分和。
 *
 * 示例 1：
 * 输入:
 *
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * 输出:
 *
 * 23
 * 解释:
 *
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 分)
 * ----> [1, 3, 3, 3, 1] (1*1=1 分)
 * ----> [1, 1] (3*3=9 分)
 * ----> [] (2*2=4 分)
 *
 */

public class RemoveBoxes {

    /*
    思路：
     */
    int[][] grades;
    public int removeBoxes(int[] boxes) {
        int N = boxes.length;
        int[][][] result = new int[100][100][100];
        return calGrades(boxes, result, 0, N-1, 0);
    }

    private int calGrades(int[] boxes, int[][][] result , int left, int right, int success){
        if(left>right){
            return 0;
        }
        if(result[left][right][success] != 0){
            return result[left][right][success];
        }
        while (right>1 && boxes[right] == boxes[right-1]){
            right--;
            success++;
        }
        result[left][right][success] = calGrades(boxes, result, left, right-1, 0) + (success+1)*(success+1);

        for(int middle = left; middle<right; middle++){
            if(boxes[middle] == boxes[right]){
                result[left][right][success] = Math.max(result[left][right][success], calGrades(boxes, result, left, middle, success+1)+calGrades(boxes, result, middle+1, right-1, 0));
            }
        }
        return result[left][right][success];
    }
}
