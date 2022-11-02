package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/11/2
 **/
public class L142 {
    public L2.ListNode detectCycle(L2.ListNode head) {
        if (head==null || head.next==null){
            return null;
        }
        L2.ListNode fast = head;
        L2.ListNode slow = head;
        while (fast!=null && slow!=null){
            if (fast.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                fast = head;
                while (slow!=fast){
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;

            }
        }
        return null;
    }
}
