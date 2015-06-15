package ojLeetCode;

import ojLeetCode.Base.ListNode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet82 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode r = deleteDuplicates(l1);
        Leet21.printList(r);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode p1, p2;
        p1 = p2 = head;
        int rNum = head.val - 1;    //递增链表，取其最小的数-1，作为替代值肯定不会和已有数据重复，导致误删
        while (p2 != null) {
            if (p2.val != p1.val) {
//                System.out.println(p1.val + " " + p2.val);
                //替换p1-p2之间所有的值
                if (p1.next != p2) {
                    while (p1 != p2) {
//                        System.out.println("in");
                        p1.val = rNum;
                        p1 = p1.next;
                    }
                }
                p1 = p2;
//                System.out.println(p1.val + "|");
            }
            p2 = p2.next;
        }
        if (p1.next != p2) {
            while (p1 != p2) {
                p1.val = rNum;
                p1 = p1.next;
            }
        }
        //去除从头节点开始的重复值
        while (head != null && head.val == rNum)
            head = head.next;

        //去除已经变成rNum数值的节点
        p1 = head;
        p2 = head == null ? null : head.next;
        while (p2 != null) {
            if (p2.val != rNum) {
                p1.next = p2;
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        //防止1，0，0这样结果发生，
        if (p1 != null && p1.next != null)
            p1.next = null;
        return head;
    }

}
