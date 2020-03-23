package JZOffer;

public class IsSubStructure {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B== null){
            return false;
        }
        boolean result = false;
        if(A.val == B.val){
            result = result || compare(A,B);
        }
        if(result){
            return result;
        }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean compare(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }

        if(A==null){
            return false;
        }

        if(A.val==B.val){
            return compare(A.left, B.left) && compare(A.right, B.right);
        }
        return false;
    }
}
