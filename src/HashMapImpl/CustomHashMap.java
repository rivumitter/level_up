package HashMapImpl;

import java.util.ArrayList;
import java.util.List;

public class CustomHashMap<K, V> {

    private List<MapNode<K, V>> bucket;
    private int size;
    private final int INITIAL_CAPACITY = 5;
    private int capacity;

    public CustomHashMap() {
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        size = 0;

        for (int i = 0; i < capacity; i++)
            bucket.add(null);
    }

    private int getBucketIndex(K key) {
        var hashCode = key.hashCode();
        return hashCode % capacity;
    }

    public void put(K key, V value) {
        var bucketIndex = getBucketIndex(key);

        MapNode<K, V> head = bucket.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) { // existing key so just update the value
                head.value = value;
                return;
            }
            head = head.next;
        }

        // set at first , u can set at last too
        head = bucket.get(bucketIndex);
        MapNode<K, V> newEntry = new MapNode<>(key, value);

        newEntry.next = head;
        bucket.set(bucketIndex, newEntry);
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);

        MapNode<K, V> head = bucket.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }

        // if get() is called without any value inside
        return null;
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);

        MapNode<K, V> head = bucket.get(bucketIndex);

        MapNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    bucket.set(bucketIndex, head.next);
                } else {
                    prev.next = head.next;
                }
                head.next = null;
                size--;
                break;
            }
            prev = head;
            head = head.next;
        }
    }

    public boolean containsKey(K key) {
        int bucketIndex = getBucketIndex(key);

        MapNode<K, V> head = bucket.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key))
                return true;
            head = head.next;
        }
        return false;
    }

    private static class MapNode<K, V> {

        K key;
        V value;

        MapNode<K, V> next;

        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
