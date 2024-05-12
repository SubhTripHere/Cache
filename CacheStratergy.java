public interface CacheStratergy<K,V> {
    boolean insertKey(K key, V val);


    void accessKey(K key);

    DLL evictKey();
}
