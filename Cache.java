import java.util.HashMap;
import java.util.Map;

public class Cache<K,V> {
   Map<K,DLL> store=new HashMap<>();
   int cap;

   CacheStratergy stratergy;
   public Cache(int cap, CacheStratergy stratergy) {
      this.cap = cap;
      this.stratergy=stratergy;
   }

   public boolean put(K key, V val){
      if(store.size()==cap){
         DLL tmp=stratergy.evictKey();
         store.remove(tmp.node.key);
      }
      Node node=new Node(key,val);
      DLL dllN=new DLL(node);
      store.put(key,dllN);
      return stratergy.insertKey(key,val);
   }

   public Object getValue(K key){
      if(store.containsKey(key)){
         stratergy.accessKey(key);
         return store.get(key).node.val;
      }

      return null;
   }
}
