class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        count,a_count,b_count=0,0,0
        a="a"
        b="b"
        if y>x:
            a,b,x,y = b,a,y,x
        for c in s:
            if c ==a:
                a_count+=1
            elif c==b:
                if a_count:
                    count+=x
                    a_count = a_count-1
                else:
                    b_count = b_count+1
            else:
                count+= y*min(a_count,b_count)
                a_count,b_count=0,0
        return count+y*min(a_count,b_count)
