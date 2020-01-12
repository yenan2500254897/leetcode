package middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你 root1 和 root2 这两棵二叉搜索树。
 *
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 *
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 * 示例 3：
 *
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 * 示例 4：
 *
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 * 示例 5：
 *
 *
 *
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 *  
 *
 * 提示：
 *
 * 每棵树最多有 5000 个节点。
 * 每个节点的值在 [-10^5, 10^5] 之间。
 *
 */
public class getAllElements {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> input1 = new ArrayList<>(10);
        List<Integer> input2 = new ArrayList<>(10);
        List<Integer> result1 = middleSearch(root1, input1);
        List<Integer> result2 = middleSearch(root2, input2);
        result1.addAll(result2);
        Collections.sort(result1);
        return result1;
    }

    public List<Integer> middleSearch(TreeNode root, List<Integer> before){
        if(root != null){
            before.add(root.val);
            if(root.left != null){
                before = middleSearch(root.left, before);
            }
            if(root.right != null){
                before =middleSearch(root.right, before);
            }
        }
        return before;
    }
}
