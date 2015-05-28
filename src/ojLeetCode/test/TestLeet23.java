package ojLeetCode.test;

import ojLeetCode.Leet23;

/**
 * Created by Mryang on 15-5-26.
 */


public class TestLeet23 {

    public static void main(String[] args){
        Leet23.NodeIndex[] heap = new Leet23.NodeIndex[5];
        for (int i=0;i<heap.length;++i){
            heap[i] = new Leet23.NodeIndex();
        }
        heap[0].val = 7;
        heap[1].val = -1;
        heap[2].val = 3;
        heap[3].val = 2;
        heap[4].val = 13;

        new TestLeet23().heapSort(heap);

    }

    public void heapSort(Leet23.NodeIndex[] heap){
        for (int i=heap.length/2;i>=0;--i){
            new Leet23().maxHeap(heap, i, heap.length);
        }
        for (int i = heap.length - 1; i >= 1; --i) {
            new Leet23().swap(heap, 0, i);
            new Leet23().maxHeap(heap, 0, i);
        }
        for(Leet23.NodeIndex node:heap){
            System.out.print(node.val+" ");
        }
        System.out.println();
    }
}
