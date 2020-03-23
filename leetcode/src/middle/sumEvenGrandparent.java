package middle;


import java.util.Collection;
import java.util.Collections;

/**
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 *
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 *  
 *
 * 提示：
 *
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 *
 */

public class sumEvenGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        int sum=0;
        return find(root, sum);
    }

    int find(TreeNode root, int sum){
        if(root == null){
            return sum;
        }
        if(root.val % 2 == 0){
            if(root.left != null){
                if(root.left.left != null){
                    sum += root.left.left.val;
                }
                if(root.left.right != null){
                    sum += root.left.right.val;
                }
            }

            if(root.right != null){
                if(root.right.left != null){
                    sum += root.right.left.val;
                }
                if(root.right.right != null){
                    sum += root.right.right.val;
                }
            }
        }
        sum = find(root.left, sum);
        sum = find(root.right, sum);
        return sum;

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
