package leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HuWei05
 * @Date 2022/8/5
 **/
public class L40 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrace(candidates,target,res,new ArrayList<>(),0,0,new boolean[candidates.length]);
        return  res;



    }

    private static void backTrace(int[] candidates, int target, List<List<Integer>> res, ArrayList<Integer> list, int sum, int index,boolean[] hasVisited) {
        if (sum==target){
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum>target)
            return;
        for (int i = index; i < candidates.length; i++) {
            if (i!=0&&candidates[i]==candidates[i-1]&&!hasVisited[i-1])
                continue;
            hasVisited[i]=true;
            sum+=candidates[i];
            list.add(candidates[i]);
            backTrace(candidates,target,res,list,sum,i+1,hasVisited);
            sum-=candidates[i];
            list.remove(list.size()-1);
            hasVisited[i]=false;

        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }


}
