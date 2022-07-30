package leetcode.top100;

/**
 * @Author HuWei05
 * @Date 2022/7/28
 **/
public class L23 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length<2){
            return lists[0];
        }
        ListNode pre  = lists[0];
        for (int i = 1; i < lists.length; i++) {
           pre = mergeTwoList(pre,lists[i]);
        }
        return pre.next;


    }
    public ListNode mergeTwoList(ListNode list1,ListNode list2) {
        ListNode firstHead = new ListNode(-1);
        ListNode pre = firstHead;
        while (list1!=null && list2!=null){
            if (list1.val>list2.val){
                pre.next = list2;
                list2=list2.next;
            }else {
                pre.next=list1;
                list1=list1.next;
            }
            pre=pre.next;
            pre.next =null;
        }
        if (list1!=null){
            pre.next = list1;
        }
        if (list2!=null){
            pre.next=list2;
        }
        return firstHead.next;

    }
    //优化 分冶
    public ListNode mergeKListsOpt(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(-2);
        ListNode node3 = new ListNode(-3);
        ListNode node4 = new ListNode(-4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode pre = node1;
        ListNode pre1=node1;
        node1=node1.next;

        pre.next=null;
    }


}
