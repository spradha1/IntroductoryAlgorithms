// Breadth first search with graph of integers
import java.util.*;

public class BFS {
    
    Hashtable<Integer, Node> table = new Hashtable<Integer, Node>(); // node storage
    ArrayList<Integer> visited = new ArrayList<Integer>(); // visited nodes
    ArrayList<Integer> frontier = new ArrayList<Integer>(); // adjacent nodes of current location of path

    public BFS (ArrayList<Node> nodes) {
        for (Node nd: nodes) {
            this.table.put(nd.key, nd);
        }
    }
    
    public boolean find (int goal) {
        frontier.add(0); // start searching from any location, in this case 0
        while (true) {
            if (frontier.isEmpty()) { // no nodes to search
                System.out.println("Not found " + goal);
                clear();
                return false;
            }
            int vertex = frontier.remove(0); // remove current path node
            if (vertex == goal) {
                System.out.println("Found " + vertex);
                clear();
                return true;
            }
            visited.add(vertex); // current node is visited
            for (int n: this.table.get(vertex).neighbours) { // add all neighbours to frontier
                if (!frontier.contains(n) && !visited.contains(n))
                    frontier.add(0, n);
            }
        }
    }

    // clear lists after search is complete
    public void clear() {
        frontier.clear();
        visited.clear();
    }
}