class LRUCache:
    def __init__(self, capacity: int):
        self.lru = OrderedDict()
        self.cap = capacity

    def get(self, key: int) -> int:
        if key not in self.lru: 
            return -1
        v = self.lru.pop(key) 
        self.lru[key] = v
        return v

    def put(self, key: int, value: int) -> None:
        if key in self.lru:
            self.lru.pop(key)
        else:
            if self.cap > 0:
                self.cap -= 1  
            else:
                self.lru.popitem(last=False) 
        self.lru[key] = value
