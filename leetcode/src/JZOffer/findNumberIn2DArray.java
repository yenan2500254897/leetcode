package JZOffer;

/**
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 思路：从右上角开始找，比他小，往左找，比他大，往右找
 * （不建议从左上角开始找，因为比他大，可能在他右边，也可能在他下边，方向不确定，导致尾递归层次深，容易超时）
 */
public class findNumberIn2DArray {
    public int[][] path;
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        path = matrix;
        if(path.length == 0){
            return false;
        }
        //System.out.println("length:"+path[0].length + " width:"+path.length);
        return route(path[0].length-1,0, target);
    }

    public boolean route(int x, int y, int target){
        if(x<0 || y>=path.length){
            return false;
        }
        if(path[y][x]==target){
            return true;
        }
        if(path[y][x]>target){
            return route(x-1,y,target);
        }
        return route(x,y+1,target);
    }
}
