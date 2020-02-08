package middle.BFS;

/**
 * 1123. 最深叶节点的最近公共祖先
 * 给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
 *
 * 回想一下：
 *
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 *  
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = [1,2,3,4]
 * 输出：[4]
 * 示例 3：
 *
 * 输入：root = [1,2,3,4,5]
 * 输出：[2,4,5]
 *
 */
public class lcaDeepestLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null){
            return root;
        }
        int leftDepth = calDepth(root.left);
        int rightDepth = calDepth(root.right);
        while (leftDepth != rightDepth){
            if(leftDepth>rightDepth){
                root = root.left;
            }else {
                root = root.right;
            }
            leftDepth = calDepth(root.left);
            rightDepth = calDepth(root.right);
        }
        return root;
    }

    private int calDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(calDepth(root.left), calDepth(root.right)) + 1;
    }
}
