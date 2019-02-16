// Runner for BFS.java
import java.util.*;

public class BFSrunner {    
    public static void main(String[] args) {
        
        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node(0, new int[]{7, 2}));
        nodes.add(new Node(7, new int[]{0, 4, 5}));
        nodes.add(new Node(2, new int[]{0, 3}));
        nodes.add(new Node(3, new int[]{2, 6}));
        nodes.add(new Node(4, new int[]{7, 5, 6}));
        nodes.add(new Node(5, new int[]{7, 4}));
        nodes.add(new Node(6, new int[]{3, 4}));
        BFS bfs = new BFS(nodes);
        bfs.find(2);
        bfs.find(8);
        bfs.find(3);
    }
}