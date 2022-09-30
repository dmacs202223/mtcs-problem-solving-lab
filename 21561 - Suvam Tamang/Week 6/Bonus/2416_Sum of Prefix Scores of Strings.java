class Solution {
    TrieNode head = new TrieNode();
    
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        int count = 0;
        boolean isEnd = false;
    }
    
    public void insert(String word) {
        if(word == null)
            return;
        TrieNode node = head;
        for(Character ch : word.toCharArray()) {
            if(!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
            node.count++;
        }
        node.isEnd = true;
    }
    
    public int sumPrefixes(String word) {
        if(word == null)
            return 0;
        TrieNode node = head;
        int result = 0;
        for(Character ch : word.toCharArray()) {
            if(!node.children.containsKey(ch))
                return 0;
            node = node.children.get(ch);
            result += node.count;
        }
        return result;
    }
    
    public int[] sumPrefixScores(String[] words) {
        int[] result = new int[words.length];
        int index = 0;
        for(String str : words)
            insert(str);
        for(String str : words) {
            result[index++] = sumPrefixes(str);
        }
        return result;
    }
}
