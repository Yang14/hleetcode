package ds;

/**
 * Created by Mryang on 15-3-16.
 */
public class TestList {
    private Node head = null;

    public TestList(){
       head = null;
    }

    public static void addNode(TestList testList, Node node){
        if(node == null)    return;
        if(testList.head == null){
            testList.head = node;
        }
        else {
            Node pnode = testList.head;
            while ( pnode.next != null)
                pnode = pnode.next;
            pnode.next = node;
        }
    }

    public static void printListNode(TestList testList){
        Node pnode = testList.head;
        while ( pnode != null){
            System.out.print(pnode.data +" ");
            pnode = pnode.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        TestList l = new TestList();
        addNode(l,Node.getNode(1));
        addNode(l,Node.getNode(2));
        addNode(l,Node.getNode(3));

        printListNode(l);

    }
}
