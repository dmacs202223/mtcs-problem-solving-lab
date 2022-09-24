# Approach 1: Define a "TrieNode"
class TrieNode:
    
    def __init__(self):
        self.children = collections.defaultdict(TrieNode)
        self.end_word = False
        
class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for letter in word:
            node = node.children[letter]
        node.end_word = True

    def search(self, word: str) -> bool:
        node = self.root
        for letter in word:
            if letter not in node.children:
                return False
            node = node.children[letter]
        if node.end_word: return True

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for letter in prefix:
            if letter not in node.children:
                return False
            node = node.children[letter]
        return True
      
      
# Approach 2: A special marker for "end of word"
class Trie:

    def __init__(self):
        self.trie = {}
        self.end_word = '.'

    def insert(self, word: str) -> None:
        t = self.trie
        for letter in word:
            if letter not in t:
                t[letter] = {}
            t = t[letter]
        t[self.end_word] = True

    def search(self, word: str) -> bool:
        t = self.trie
        for letter in word:
            if letter not in t:
                return False
            t = t[letter]
        return True if self.end_word in t else False

    def startsWith(self, prefix: str) -> bool:
        t = self.trie
        for letter in prefix:
            if letter not in t:
                return False
            t = t[letter]
        return True
