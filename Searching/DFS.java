// depth first search with graph as adjacency matrix
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class DFS {
  int v;
  int e;
  boolean[][] adj;

  public DFS (File file) {
    try {
      Scanner scanner = new Scanner (file);
      this.v = scanner.nextInt();
      this.e = scanner.nextInt();

      this.adj = new boolean[this.v][this.v];
      while (scanner.hasNextInt()) {
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        this.adj[i][j] = true;
        this.adj[j][i] = true;
      }
      scanner.close();
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void find (int start, int goal) {
    ArrayList q = new ArrayList<Integer>();
    boolean[] visited = new boolean[this.v];
    q.add(start);
    while (!q.isEmpty()) {
      int cur = (Integer)q.remove(q.size()-1);
      visited[cur] = true;
      System.out.print(cur + " ");
      if (goal == cur) {
        System.out.print("found!\n");
        break;
      }
      for (int k=0; k<v; k++) {
        if (!visited[k] && this.adj[cur][k]) {
          visited[k] = true;
          q.add(k);
        }
      }
    }
  }
}