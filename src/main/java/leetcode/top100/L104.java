package leetcode.top100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/14
 **/
public class L104 {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int pathLength=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            pathLength++;
            while (size-->0){
                TreeNode treeNode = queue.poll();
                if (treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
        }
        return pathLength;
    }
}
