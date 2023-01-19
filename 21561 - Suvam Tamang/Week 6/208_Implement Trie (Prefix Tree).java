class Trie {

    TrieNode head = new TrieNode();
    
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }
    
    public void insert(String word) {
        if(word == null)
            return;
        TrieNode node = head;
        for(Character ch : word.toCharArray()) {
            if(!node.children.containsKey(ch))
                node.children.put(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        if(word == null)
            return false;
        TrieNode node = head;
        for(Character ch : word.toCharArray()) {
            if(!node.children.containsKey(ch))
                return false;
            node = node.children.get(ch);
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        if(prefix == null)
            return false;
        TrieNode node = head;
        for(char ch : prefix.toCharArray()) {
            if(!node.children.containsKey(ch)){
                return false;
            } 
            node = node.children.get(ch);
            
        }
        return true; 
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
