
class TrieNode{
    public:
    unordered_map<char, TrieNode*> children;
    char val;
    bool isEnd = false;
    int count =0;
    
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
                node->count++;
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
        int count(string word){
            int count =0;
            TrieNode* node = root;
            for(int i = 0; i < word.size(); i++){
                char c = word[i];
                //if(node->children.find(c) == node->children.end()) return false;
                node = node->children[c];
                count +=node->count;
            }

            return count; 
        }
};





class Solution {
    
    
public:
    vector<int> sumPrefixScores(vector<string>& words) {
        
        Trie* root = new Trie();
        
        for(int i=0;i<words.size();i++){
            root->insert(words[i]);
        }
        vector<int> ans;
        int count =0;
        for(int i=0;i<words.size();i++){
            
            ans.push_back(root->count(words[i]));
            
        }
        return ans;
    }
};