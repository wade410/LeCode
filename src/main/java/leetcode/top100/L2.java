package leetcode.top100;

/**
 * @Author HuWei05
 * @Date 2022/7/16
 **/

public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        int cnt =0;
        while(l1!=null ||l2 != null){
            int num =0;
            if(l1!=null){
                num +=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                num+= l2.val;
                l2=l2.next;
            }
            num+=cnt;
            cnt =num/10;
            pre.next = new ListNode(num%10);
            pre=pre.next;
        }
        if(cnt!=0){
            pre.next = new ListNode(cnt);
        }
        return preHead.next;

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
