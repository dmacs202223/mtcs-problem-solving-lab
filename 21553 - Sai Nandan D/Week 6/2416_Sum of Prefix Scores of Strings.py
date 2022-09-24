class TrieNode:
    
    def __init__(self):
        self.children = collections.defaultdict(TrieNode)
        self.count = 0
            
class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for letter in word:
            node = node.children[letter]
            node.count += 1            

    def score(self, word: str) -> bool:
        node = self.root
        total = 0
        for letter in word:            
            node = node.children[letter]
            total += node.count
        return total
    

class Solution:                                        
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        t = Trie()
        for w in words:
            t.insert(w)
            
        return [t.score(w) for w in words]
