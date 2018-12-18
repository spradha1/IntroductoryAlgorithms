public class Hnode <K, V> {
    K key;
    V value;
    Hnode next;

    public Hnode (K key, V value) {
        this.key = key;
        this.value = value;
    }
}