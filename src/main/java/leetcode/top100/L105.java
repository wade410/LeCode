package leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/14
 **/
public class L105 {


    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map= new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return PreOrderBuildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode PreOrderBuildTree(int[] preorder,int preL,int prerR,int[] inorder,int orederL,int orderR){
        if (preL>prerR)
            return null;
        int temp =preorder[preL];
        int order = map.get(temp);
        TreeNode root =new TreeNode(temp);
        int size = order-orederL;
        root.left=PreOrderBuildTree(preorder,preL+1,preL+size,inorder,orederL,order-1);
        root.right=PreOrderBuildTree(preorder,preL+size+1,prerR,inorder,order+1,orderR);
        return root;
    }



}
