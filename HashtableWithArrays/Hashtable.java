// implementation of hashtable with only arrays
public class Hashtable <K, V> {
    int size;
    int cap;
    Hnode[] data;

    public Hashtable() {
        size = 0;
        cap = 100;
        data = new Hnode[cap];
        for (Hnode n: data)
            n = null;
    }

    // hash algorithm
    int indexer(K key) {
        int hash = key.hashCode();
        return hash%cap;
    }

    V get(K key){
        int index = indexer(key);
        Hnode node = data[index];
        while (node!=null) {
            if (node.key.equals(key))
                return (V)node.value;
            node = node.next;
        }
        return null;
    }

    V remove(K key) {
        int index = indexer(key);
        Hnode node = data[index];
        Hnode prev = null;
        while (node!=null) {
            if (node.key.equals(key))
                break;
            prev = node;
            node = node.next;
        }
        if (node == null)
            return null;
        size--;
        if (prev == null)
            data[index] = node.next;
        else
            prev.next = node.next;
        return (V)node.value;
    }

    V put(K key, V value) {
        int index = indexer(key);
        Hnode node = data[index];
        while (node!=null) {
            if (node.key.equals(key)) {
                V val = (V)node.value;
                node.value = value;
                return val;
            }
            node = node.next;
        }
        size++;
        Hnode newNode = new Hnode<K,V> (key, value);
        newNode.next = data[index];
        data[index] = newNode;

        if (size*1.0/cap > 0.8)
            rehash();
        return null;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void rehash(){
        cap += 100;
        Hnode[] newData = new Hnode[cap];
        for (int k=0; k<newData.length; k++) {
            if (k<data.length)
                newData[k] = data[k];
            else
                newData[k] = null;
        }
        data = null;
        data = newData;
    }
}