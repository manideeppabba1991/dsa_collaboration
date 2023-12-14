import java.util.Hashtable;

public class MyHashSet {

    private Hashtable<String, Object> hashTable;

    public MyHashSet() {
        this.hashTable = new Hashtable<>();
    }

    public boolean add(String key) {
        return hashTable.put(key, new Object()) == null;  // TC = O(1)
    }

    public boolean remove(String key) { //TC = O(1)
        return hashTable.remove(key) == null;
    }

    public boolean contains(String key) { //TC = O(1)
        return hashTable.containsKey(key);
    }

    public int size() {
        return hashTable.size();
    }

    public boolean isEmpty() {
        return hashTable.isEmpty();
    }

    public void clear() {
        hashTable.clear();
    }

    @Override
    public String toString() {
        return "[hashTable=" + hashTable.keySet() + "]";
    }
}
