package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/15
 **/
public class L114 {
    public void flatten(TreeNode root) {
        if (root!=null){
            flatten(root.left);
            flatten(root.right);
            TreeNode pre = root.right;
            root.right=root.left;
            root.left=null;
            while (root.right!=null){
                root=root.right;
            }
            root.right=pre;
        }else {
            return;
        }

    }
}
