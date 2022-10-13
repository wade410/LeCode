package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/13
 **/
public class L101 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return false;
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left==null && right==null){
            return true;
        }
        if (left==null || right==null){
            return false;
        }
        if (left.val!=right.val)
            return false;
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }


}
