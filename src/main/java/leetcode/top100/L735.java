package leetcode.top100;

import java.util.Stack;

/**
 * @Author HuShengHengao
 * @Date 2022/7/13
 **/
public class L735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            boolean mark = true;
            while (!stack.isEmpty() && stack.peek() > 0 && i < 0 && mark) {
                mark = stack.peek() < -i;
                if (stack.peek() <= -i) {
                    stack.pop();
                }
            }
            if (mark) {
                stack.push(i);
            }
        }
        int[] res = new int[stack.size()];
        int cnt = 0;
        while (stack.isEmpty()) {
            res[cnt++] = stack.pop();
        }
        return res;
    }

}
