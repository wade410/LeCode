package leetcode.top100;

/**
 * @Author HuWei05
 * @Date 2022/7/27
 **/
public class L19 {
    public class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode firstHead = new ListNode(-1);
        firstHead.next = head;
        ListNode pre  = firstHead;
        ListNode next = head;
        while(next!=null&&n>0){
            next=next.next;
            n--;
        }
        while(next!= null){
            next=next.next;
            pre =pre.next;
        }
        pre.next = pre.next.next;
        return  firstHead.next;
    }
}
