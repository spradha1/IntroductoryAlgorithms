// dijkstra algorithm on graph represented by 2D array
import java.util.*;

public class Dijkstra {
    
    private int[] dist; // distances of all vertices from the source
    private int[] prev; // preceder in shortest path 
    private Hashtable<Integer, Node> Q; // unvisited vertices

    public Dijkstra() {
        
    }

    // the shortest paths finder
    void dijkstra (int[][] graph, int src) {
        this.dist = new int[graph.length];
        this.prev = new int[graph.length];
        this.Q = new Hashtable<Integer, Node>();

        // allocate neighbours to each vertex as in the graph
        for(int k=0; k<graph.length; k++) {
            Node node = new Node(k);
            for (int d=0; d<graph[k].length; d++) {
                if (graph[k][d] != 0)
                    node.addNeighbour(d);
            }
            Q.put(k, node);
        }

        // distance is infinity to every undiscovered vertex at first
        for(int v=0; v<graph.length; v++) {
            dist[v] = Integer.MAX_VALUE;
            prev[v] = -1;
        }

        dist[src] = 0; // source distance is obvious

        while(!Q.isEmpty()) {

            // will get source first
            int u = closest();
            Node nu = Q.get(u);
            Q.remove(u); // mark visited

            // check with neighbours
            for (int ne: nu.neighbours) {
                if (dist[ne] > dist[u] + graph[u][ne]) {
                    dist[ne] = dist[u] + graph[u][ne]; // update distance if lower 
                    prev[ne] = u;  // update preceder
                }
            }
        }

        // display answers
        System.out.println("Vertex " + " Length of best path from source " + src);
        for (int p=0; p<dist.length; p++) {
            System.out.println(p + " --> " + dist[p]);
        }
        System.out.println("Best paths between vertices to source: " + src);
        for (int b=0; b<dist.length; b++) {
            System.out.print(b);
            int r = prev[b];
            if (r<0) {
                System.out.println();
                continue;
            }
            while (r != src) {
                System.out.print(" -> " + r);
                r = prev[r];    
            }
            System.out.print(" -> " + r +"\n");
        }
    }

    // find next nearest vertex to explore
    int closest() {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int j=0; j<this.dist.length; j++) {
            if (Q.containsKey(j) && dist[j] < min) {
                min = dist[j];
                minIndex = j;
            }
        }
        return minIndex;
    }

    // Node class
    class Node {

        ArrayList<Integer> neighbours;
        int key;

        public Node (int key) {
            this.key = key;
            this.neighbours = new ArrayList<Integer>();
        }

        void addNeighbour(int num) {
            this.neighbours.add(num);
        }
    }
}