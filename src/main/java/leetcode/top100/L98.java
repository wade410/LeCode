package leetcode.top100;

import java.util.Stack;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/13
 **/
public class L98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }

    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {
        if (root==null)
            return true;
        if (root.val>=maxValue || root.val<=minValue){
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root, root.val, maxValue);
    }


    public boolean isValidBSTNoneRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node;
        long preNext = Long.MIN_VALUE;
        while (root!=null || !stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else {
                node = stack.pop();
                if (preNext>=node.val){
                    return false;
                }
                preNext = node.val;
                root=node.right;

            }
        }
        return true;


    }


}
