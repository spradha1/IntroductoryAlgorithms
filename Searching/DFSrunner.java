import java.io.File;

public class DFSrunner {

  public static void main (String[] args) {
    File file = new File(args[0]);
    DFS dfs = new DFS(file);
    dfs.find(0, 3);
  }
}