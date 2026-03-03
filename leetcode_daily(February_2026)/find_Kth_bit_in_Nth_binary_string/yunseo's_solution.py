class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        s = ["0"]

        def invert(x):
            return x.translate(str.maketrans("01", "10"))
        
        for i in range(1, n):
            prev = s[i-1]
            new_s = prev + "1" + invert(prev)[::-1]
            s.append(new_s)
        
        return s[n-1][k-1]
             