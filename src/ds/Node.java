package ds;

/**
 * Created by Mryang on 15-3-16.
 */
public class Node {

    public int data;
    public Node next;
    public Node(){

    }
    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public static Node getNode(int data){
        return new Node(data);
    }

    public static void addNode(Node head, Node node){
        if(node == null)    return;
        if(head == null){
            head = node;
            System.out.print(head.data);
        }
        else {
            Node pnode = head;
            while ( pnode.next != null)
                pnode = pnode.next;
            pnode.next = node;
        }
    }

    public static void printListNode(Node head){
        Node pnode = head;
        while ( pnode != null){
            System.out.print(pnode.data +" ");
            pnode = pnode.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        int data[] = {1,2,3,4};
        Node head = null;//getNode(data[0]);
        addNode(head,getNode(data[1]));
        //System.out.print(head.data);
        addNode(head,getNode(data[2]));
        addNode(head,getNode(data[3]));

        printListNode(head);
    }
}
