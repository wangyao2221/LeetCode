package Test.hashmap;

public class Node<K,V> {
    final private K key;
    private V value;
    private Node<K,V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
