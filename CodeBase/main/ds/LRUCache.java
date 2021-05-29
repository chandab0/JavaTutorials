package main.ds;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, Integer> cache;

    public LRUCache(final int cacheCapacity) {
        this.cache = new LinkedHashMap<Integer, Integer>(cacheCapacity, 100.0f, true) {
			private static final long serialVersionUID = 1L;

			@Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > cacheCapacity;
            }
        };
    }

    public int get(int key) {
        if (cache.containsKey(key))
            return cache.get(key);
        return -1;
    }

    public void set(int key, int value) {
        cache.put(key, value);
    }

}