// Prefix tree
class Trie {
    Trie[] children = new Trie[52];
    boolean end;
    
    Trie () {
        end = false;
        for (Trie tr: children)
            tr = null;
    }
    
    void insert (String w) { 
        int i;
        Trie trie = this;

        for (int l = 0; l < w.length(); l++) {
            int v = w.charAt(l);
            if (v>96)
                i = v%97 + 26;
            else
                i = v%65;
            if (trie.children[i] == null) 
                trie.children[i] = new Trie(); 
       
            trie = trie.children[i]; 
        }
        
        trie.end = true;
    }
    
    boolean search (String w) {
        int i;
        Trie trie = this;

        for (int l = 0; l < w.length(); l++) {
            int v = w.charAt(l);
            if (v>96)
                i = v%97 + 26;
            else
                i = v%65;
            if (trie.children[i] == null) 
                return false; 
       
            trie = trie.children[i]; 
        }   
        return (trie != null && trie.end);
    }
}