class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        for length in range(len(s), 0, -1):
            
            for i in range(len(s) - length + 1):
                sub = s[i : i + length]
                
                if sub == sub[::-1]:
                    return sub
        return ""

