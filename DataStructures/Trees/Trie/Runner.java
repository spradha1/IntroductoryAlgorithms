public class Runner {
    public static void main(String[] args) {
        String[] parts = {"a", "mel", "lon", "el", "An"};
        Trie tr = new Trie();
        for (String p: parts) {
            tr.insert(p);
        }

        parts[3] = "why";

        for (String p: parts) {
            if(tr.search(p))
                System.out.println("Found");
            else
                System.out.println("Not found");
        }
    }
}