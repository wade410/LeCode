package leetcode.top100;

/**
 * @Author HuWei05
 * @Date 2022/7/27
 **/
public class L21 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                pre.next = new ListNode(list2.val);
                pre = pre.next;
                list2 = list2.next;
            } else {
                pre.next = new ListNode(list1.val);
                pre = pre.next;
                list1 = list1.next;
            }
        }
        if (list1 != null)
            pre.next = list1;
        if (list2 != null)
            pre.next = list2;
        return preHead.next;
    }
}
