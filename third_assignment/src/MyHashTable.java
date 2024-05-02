import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private ArrayList<LinkedList<HashNode<K, V>>> buckets;
    private int capacity;
    static class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode (K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    public MyHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashTable(int M) {
        this.capacity = M;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<HashNode<K, V>> bucket = buckets.get(index);
        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        bucket.add(new HashNode<>(key, value));
    }

    public void get(K key) {
        int index = hash(key);
        LinkedList<HashNode<K, V>> bucket = buckets.get(index);
        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return;
            }
        }
    }

    public V remove(K key) {
        int index = hash(key);
        LinkedList<HashNode<K, V>> bucket = buckets.get(index);
        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                V value = node.value;
                bucket.remove(node);
                return value;
            }
        }
        return null;
    }

    public boolean contains(V value) {
        for (LinkedList<HashNode<K, V>> bucket : buckets) {
            for (HashNode<K, V> node : bucket) {
                if (node.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (LinkedList<HashNode<K, V>> bucket : buckets) {
            for (HashNode<K, V> node : bucket) {
                if (node.value.equals(value)) {
                    return node.key;
                }
            }
        }
        return null;
    }

    public List<LinkedList<HashNode<K, V>>> getBuckets() {
        return buckets;
    }
}