package ojLeetCode;

import ojLeetCode.Base.ListNode;

/**
 * Created by Mryang on 15-5-26.
 */
public class Leet24 {

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

        ListNode lr = swapPairs(l1);
        while (lr != null) {
            System.out.print(lr.val + " -> ");
            lr = lr.next;
        }
        System.out.println();
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p = null;
        head = p2;
        while (p2 != null){
            p1.next = p2.next;
            p2.next = p1;
            p = p1;
            if(p1.next == null)
                return head;
            p1 = p1.next;
            p2 = p1.next;
            if(p2 == null)
                p.next = p1;
            else
                p.next = p2;
        }
        return head;
    }
}
