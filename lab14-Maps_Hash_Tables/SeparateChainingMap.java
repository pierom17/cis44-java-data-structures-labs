import java.util.ArrayList;
import java.util.LinkedList;

// Use the same Entry<K, V> and MapADT<K, V> as in Project 1

// --- 4. Implementation: Separate Chaining Hash Map ---
// Time Complexity: get/put/remove are O(1) expected (Amortized)
class SeparateChainingMap<K, V> implements MapADT<K, V> {
    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int size = 0;
    private final int N = 11; // Use a prime number for table capacity

    public SeparateChainingMap() {
        table = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<Entry<K, V>>());
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % N);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // TODO: Complete this method (O(1) expected time)
    public V get(K key) {
        // 1. Calculate the hash index (bucket).
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // 2. Search linearly within the bucket's linked list for the key.
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        // 3. If key is not found in the bucket, return null.
        return null;
    }

    public V put(K key, V value) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // Check if key already exists in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.setValue(value);
            }
        }

        // Key is new: add to the front of the list
        bucket.addFirst(new Entry<K, V>(key, value));
        size++;
        return null;
    }

    public V remove(K key) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            V oldValue = toRemove.getValue();
            bucket.remove(toRemove);
            size--;
            return oldValue;
        }
        return null;
    }

    public static void main(String[] args) {
        SeparateChainingMap<String, String> map = new SeparateChainingMap<>();

        System.out.println("put(M, Mango): " + map.put("A", "Mango"));
        System.out.println("put(L, Limon): " + map.put("L", "Limon"));
        System.out.println("put(D, Dragonfruit): " + map.put("W", "Dragonfruit"));

        System.out.println("get(M): " + map.get("M"));
        System.out.println("get(L): " + map.get("L"));
        System.out.println("get(D): " + map.get("D"));

        System.out.println("put(L, Lime): " + map.put("L", "Limon"));

        System.out.println("get(L): " + map.get("L"));

        System.out.println("remove(M): " + map.remove("M"));
        System.out.println("get(M): " + map.get("M"));

        System.out.println("size(): " + map.size());
    }
}