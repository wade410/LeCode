package leetcode.top100;

import java.util.*;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/13
 **/
public class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        int cnt=0;
        while (!queue.isEmpty()){
            cnt = queue.size();
            List<Integer> list = new ArrayList<>();
            while (cnt-->0){
                node=queue.poll();
                list.add(node.val);
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
            if (list.size()>0){
                res.add(new ArrayList<>(list));
            }
        }
        return res;

    }
}
