/**
 * Created by Mryang on 15-3-28.
 */
public class leet3 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode p1=l1,p2=l2;
        ListNode l3 = null;
        ListNode pNode = null,pNext=null;
        int overFlag = 0;
        int val = 0;
        while (p1 != null && p2 !=null){
            int sum = p1.val + p2.val + overFlag;
            if(sum / 10 == 1){
                val = sum % 10;
                overFlag = 1;
            }else {
                val = sum;
                overFlag = 0;
            }
            if(l3 == null){
                l3 = new ListNode(val);
                pNext = l3;
            }
            else{
                pNode = new ListNode(val);
                pNext.next = pNode;
                pNext = pNode;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        if(overFlag == 1){
            pNode = new ListNode(1);
            if(p1 == null && p2 == null)
                pNext.next = pNode;
            else
                pNext.next = p1 != null ? addTwoNumbers(pNode,p1):addTwoNumbers(pNode,p2);
        }else
            pNext.next = p1 != null ? p1:p2;
/*
        if(p2 != null){
            if (overFlag == 1){
                pNode = new ListNode(1);
                pNext.next = addTwoNumbers(pNode,p2);
            }
            else
                pNext.next = p2;
        }
        else if(p1 != null){
            if (overFlag == 1){
                pNode = new ListNode(1);
                pNext.next = addTwoNumbers(pNode,p1);
            }
            else
                pNext.next = p1;
        }else if(overFlag == 1){
            pNode = new ListNode(1);
            pNext.next = pNode;
        }*/
        return l3;
    }

    public static void print(ListNode listNode){
        ListNode p = listNode;
        while (p != null){
            System.out.print(p.val);
            p = p.next;
        }
        System.out.println();

    }
    public static void main(String[] args){

        ListNode l1 = new leet3.ListNode(5);
//        ListNode l12 = new leet3.ListNode(4);
//        ListNode l13 = new leet3.ListNode(5);
//        l1.next = l12;
//        l12.next = l13;

        ListNode l2 = new leet3.ListNode(5);
        ListNode l22 = new leet3.ListNode(9);
        ListNode l23 = new leet3.ListNode(9);
        ListNode l24 = new leet3.ListNode(9);
        l2.next = l22;
        l22.next = l23;
        l23.next = l24;

        print(l1);
        print(l2);

        ListNode l3 = addTwoNumbers(l1,l2);
        print(l3);

    }
}
