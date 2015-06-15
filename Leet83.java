package ojLeetCode;

import ojLeetCode.Base.ListNode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet83 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;
        ListNode r  = deleteDuplicates(l1);
        Leet21.printList(r);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p1,p2;
        p1 = p2 = head;
        while (p2 != null){
            if (p2.val != p1.val && p1.next != p2){
                p1.next = p2;
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        if (p1 != null)
            p1.next = null;
        return head;
    }

}
