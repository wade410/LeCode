package leetcode.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/10
 **/
public class L94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
    public List<Integer> inorderTraversalOpt(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else {
                TreeNode node = stack.pop();
                list.add(node.val);
                root=node.right;
            }
        }
         return list;
    }
}
