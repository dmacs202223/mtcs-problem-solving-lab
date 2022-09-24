
class TrieNode{
    public:
    unordered_map<char, TrieNode*> children;
    char val;
    bool isEnd = false;
    
    TrieNode(){}
    
    TrieNode(char v){
        this->val = v;
    }
};
   



class Trie {
    
    public:
    TrieNode* root;

    
    
public:
    Trie() {
    root = new TrieNode();
    }
    
    void insert(string word) {
       TrieNode* node = root;
        for(int i = 0; i < word.size(); i++){
            char c = word[i];
            if(node->children.find(c) == node->children.end()){
                node->children[c] = new TrieNode(c);                        
            }
            
            node = node->children[c];                                               
        }
        
        node->isEnd = true;   
    }
    
    bool search(string word) {
        TrieNode* node = root;
        for(int i = 0; i < word.size(); i++){
            char c = word[i];
            if(node->children.find(c) == node->children.end()) return false;
            node = node->children[c];
        }
        
        return node->isEnd; 
    }
    
    bool startsWith(string prefix) {
        TrieNode* node = root;
        for(int i = 0; i < prefix.size(); i++){
            char c = prefix[i];
            if(node->children.find(c) == node->children.end()) return false;
            node = node->children[c];
        }
        
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */