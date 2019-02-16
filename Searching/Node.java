// Node class for search algorithms
public class Node {
    public int key;
    public int[] neighbours;
    public Node(int key, int[] neighbours) {
        this.key = key;
        this.neighbours = neighbours;
    }
}