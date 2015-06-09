package ojLeetCode;

import ojLeetCode.Base.ListNode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet61 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode r = rotateRight(l5, 3);
        Leet21.printList(r);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null ||  k <= 0) return head;
        ListNode p1,p2;
        p1 = p2 = head;
        int len = 0;
        while (p1 != null){
            p1 = p1.next;
            len++;
        }
        k = k % len;        //k超出长度的话就取余数，不然就不正确！
        for (int i=0;i<k;++i){      //两个指针，前一个先走k步
            if (p2.next != null)
                p2 = p2.next;
            else
                return head;
        }

        p1 = head;
        while (p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        //核心代码：指针收尾相连，最后返回head
        p2.next = head;
        head = p1.next;
        p1.next = null;
        return head;
    }

}
