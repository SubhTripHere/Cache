public class DLL {
    Node node;
    DLL prev;
    DLL next;


    DLL head;
    DLL tail;

    public DLL(Node node, DLL head, DLL tail) {
       this.node=node;
        this.head=head;
        this.tail=tail;
        this.prev=null;
        this.next=null;
    }

    public DLL( Node node) {
        this.node = node;
    }

    public void addAtStart(DLL node1){
        DLL node=node1;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }

    public void atAtLast(DLL node1){
        DLL node=node1;
        node.prev=tail.prev;
        tail.prev.next=node;
        node.next=tail;
        tail.prev=node;

    }

    public DLL removeNodeFromLast(){
        DLL tmp=tail.prev;
        tail.prev=tail.prev.prev;
        tail.prev.prev.next=tail;
        return tmp;
    }
    public DLL removeNodeFromStart(){
        DLL tmp=head.next;
        head.next=head.next.next;
        head.next.next.prev=head;
        return tmp;
    }
}
