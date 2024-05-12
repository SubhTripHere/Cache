import java.util.Map;

public class LRUCacheStratergyImpl<K,V> implements CacheStratergy<K,V>{
    Map<K,DLL> store;
    DLL head;
    DLL tail;
    public LRUCacheStratergyImpl(DLL head, DLL tail,Map<K,DLL> store) {
        this.head = head;
        this.tail = tail;
        this.store=store;
    }

    @Override

    public boolean insertKey(K key, V val) {
        if(store.containsKey(key)){
            accessKey(key);
            return false;
        }

        Node node=new Node(key,val);
        DLL dllNode=new DLL(node);
        head.next.next.prev=dllNode;
        dllNode.next=head.next.next;
        head.next=dllNode;
        dllNode.prev=head;

        store.put(key,dllNode);
        return true;
    }

    @Override
    public void accessKey(K key) {
        DLL temp=store.get(key);
        temp.next.prev=temp.prev;

        temp.prev.next=temp.next;
        head.addAtStart(temp);
    }

    @Override
    public DLL evictKey() {
        DLL tmp=tail.prev;
        tmp.prev.next=tail;
        tail.prev=tmp.prev;
        return tmp;
    }
}
