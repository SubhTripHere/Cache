import java.util.HashMap;

public class CustomCache {
    public static void main(String[] args) {
        Node n1=new Node(-1,-1);
        Node n2=new Node(-1,-1);
        DLL head=new DLL(n1);
        DLL tail=new DLL(n2);
        head.next=tail;
        tail.prev=head;
        Cache<Integer,Integer> cache=new Cache<>(3,new LRUCacheStratergyImpl(head,tail,new HashMap()));
    }
}
