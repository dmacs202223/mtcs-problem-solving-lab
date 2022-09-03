class Solution:
    def minInsertions(self, s: str) -> int:
        count = 0
        right_req = 0
        for c in s:
            if c== "(":
                if right_req%2 :
                    right_req-=1
                    count+=1
                right_req+=2
            if c==")":
                right_req-=1
                if right_req < 0:
                    right_req+=2
                    count+=1
        return count+right_req
