package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/11/1
 **/
public class L141 {
    public boolean hasCycle(L2.ListNode head) {
        if (head==null || head.next ==null){
            return false;
        }
        L2.ListNode pre = head.next.next;
        while (head!=null&&pre!=null){
            if (head==pre)
                return true;
            if (pre.next!=null){
                pre=pre.next.next;
            }else {
                pre = pre.next;
            }
            head = head.next;
        }
        return false;
    }
}
