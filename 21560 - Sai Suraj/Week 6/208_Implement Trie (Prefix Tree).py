class Trie:

    def __init__(self):
        self.trie = {}

    def insert(self, word: str) -> None:
        contents = self.trie
        word+="#"
        for c in word:
            if c not in contents:
                contents[c] ={}
            contents=contents[c]

    def search(self, word: str) -> bool:
        contents = self.trie
        word+="#"
        for c in word:
            if c not in contents:
                return False
            contents = contents[c]
        return True

    def startsWith(self, prefix: str) -> bool:
        contents= self.trie
        for c in prefix:
            if c not in contents:
                return False
            contents = contents[c]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
