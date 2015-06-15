package ojLeetCode;

import ojLeetCode.Base.ListNode;

/**
 * Created by Mryang on 15-5-21.
 */
public class Leet21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(7);

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        printList(l1);
        printList(l4);
        ListNode lr = mergeTwoLists(l1, l4);
        printList(lr);
    }

    public static void printList(ListNode ln) {
        ListNode lr = ln;
        while (lr != null) {
            System.out.print(lr.val + " ");
            lr = lr.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode tl1 = l1;
        ListNode tl2 = l2;
        ListNode t3 = new ListNode(0);
        ListNode r = t3;
        while (tl1 != null && tl2 != null) {
            if (tl1.val <= tl2.val) {
                r.next = tl1;
                tl1 = tl1.next;

            } else {
                r.next = tl2;
                tl2 = tl2.next;
            }
            r = r.next;
        }
        if (tl1 == null)
            r.next = tl2;
        if (tl2 == null)
            r.next = tl1;
        return t3.next;
    }
}
