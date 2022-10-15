class Solution:
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        n = len(vals)

        val2node = defaultdict(list)
        for i in range(n):
            val2node[vals[i]].append(i)
        
        val2edge = defaultdict(list)
        for i, j in edges:
            val2edge[max(vals[i], vals[j])].append((i, j))
        
        parent = list(range(n))
        def find(k):
            if parent[k] != k:
                parent[k] = find(parent[k])
            return parent[k]
        
        def connect(k1, k2):
            parent[find(k2)] = find(k1)

        res = 0
        for val in sorted(val2node.keys()):
            for i, j in val2edge[val]:
                connect(i, j)
            count = defaultdict(int)
            for node in val2node[val]:
                count[find(node)] += 1
            for group in count:
                res += (count[group] * (count[group] + 1))//2
        return res
