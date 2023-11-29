import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private List<Entry<K, V>>[] buckets;
    private int capacity;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new ArrayList[capacity];
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new ArrayList<>();
        }

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        if (buckets[index] != null) {
            buckets[index].removeIf(entry -> entry.getKey().equals(key));
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
