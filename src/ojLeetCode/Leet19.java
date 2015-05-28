package ojLeetCode;

import ojLeetCode.Base.ListNode;

/**
 * Created by Mryang on 15-5-18.
 */
public class Leet19 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode lr = removeNthFromEnd(l1, 1);
        while (lr != null) {
            System.out.print(lr.val + " -> ");
            lr = lr.next;
        }
        System.out.println();
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) return head;
        ListNode p2 = head;
        for (int i = 0; i < n; ++i) {
            p2 = p2.next;
        }
        if(p2==null)head=  head.next;
        else {
            ListNode p1 = head;
            while (p2.next!=null){
                p1 = p1.next;
                p2 = p2.next;
            }
            p1.next = p1.next.next;
        }
        return head;
    }

}
