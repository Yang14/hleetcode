package ojLeetCode;

import ojLeetCode.Base.ListNode;

import java.util.*;

/**
 * Created by Mryang on 15-5-26.
 */
public class Leet23 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(7);

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(8);
        ListNode l7 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode r = mergeKLists(new ListNode[]{l1,l4});
        Leet21.printList(r);
    }

    public static void maxHeap(NodeIndex[] array, int index, int heapSize) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int large = index;
        if (left < heapSize && array[left].val < array[index].val) large = left;
        if (right < heapSize && array[right].val < array[large].val) large = right;

        if (large != index) {
            swap(array, large, index);
            maxHeap(array, large, heapSize);
        }
    }
    public static void swap(NodeIndex[] array, int b, int e){
        NodeIndex temp = array[b];
        array[b] = array[e];
        array[e] = temp;
    }
    public static class NodeIndex{
        public int val;
        int index;
        public NodeIndex(){

        }
        public NodeIndex(int val,int index){
            this.val = val;
            this.index = index;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 1 ) return null;

        ListNode result = new ListNode(0);
        ListNode head = result;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val)
                    return -1;
                else if(o1.val > o2.val)
                    return 1;
                return 0;
            }
        };

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(1,comparator);
        for (ListNode listNode:lists)
            if(listNode != null)
                pq.add(listNode);
        while (!pq.isEmpty()){
            head.next = pq.poll();
            ListNode node = head.next.next;
            if(node != null){
                pq.add(node);
            }
            head = head.next;
        }
        return result.next;
    }

    public static ListNode mergeKLists3(ListNode[] lists) {
        if(lists == null || lists.length < 1 ) return null;

        ListNode result = new ListNode(0);
        ListNode head = result;

        NodeIndex[] heap = new NodeIndex[lists.length];

        for (int i=0;i<lists.length;++i){
            heap[i] = new NodeIndex();
            if(lists[i] == null){
                heap[i].val = Integer.MAX_VALUE;
                heap[i].index = i;
            }
            else {
                heap[i].val = lists[i].val;
                heap[i].index = i;
                lists[i] = lists[i].next;
            }
        }
        for (int i=heap.length/2;i>=0;--i){
            maxHeap(heap,i,heap.length);
        }
        while (heap[0].val != Integer.MAX_VALUE){


            head.next = lists[heap[0].index];
            lists[heap[0].index] = head.next.next;

            heap[0].val = lists[heap[0].index]==null?Integer.MAX_VALUE:lists[heap[0].index].val;

//            if(head.next != null)
//                lists[heap[0].index] = head.next.next;
            head = head.next;

            maxHeap(heap,0,heap.length);
        }
        /*while (heap[0].val != Integer.MAX_VALUE){
            ListNode node = new ListNode(heap[0].val);
            head.next = lists[heap[0].index];
            lists[heap[0].index] = lists[heap[0].index].next;
            head = head.next;
            if (head == null) {
                result = node;
                head = node;
            } else {
                head.next = node;
                head = node;
            }

            heap[0].val = lists[heap[0].index]==null?Integer.MAX_VALUE:lists[heap[0].index].val;

            if(lists[heap[0].index]!=null){
                lists[heap[0].index] = lists[heap[0].index].next;
            }
            maxHeap(heap,0,heap.length);
        }*/

        return result.next;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode result = null;
        List<Integer> ls = new ArrayList<Integer>();
        ListNode head = null;
        for (ListNode listNode : lists) {
            head = listNode;
            while (head != null) {
                ls.add(head.val);
                head = head.next;
            }
        }
        Collections.sort(ls);
        head = null;
        for (int e : ls) {
            ListNode node = new ListNode(e);
            if (head == null) {
                result = node;
                head = node;
            } else {
                head.next = node;
                head = node;
            }
        }
        return result;
    }
}
