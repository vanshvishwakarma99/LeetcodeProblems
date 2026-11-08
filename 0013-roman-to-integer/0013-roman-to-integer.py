class Solution:
    def romanToInt(self, s: str) -> int:
        roman_map = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        ans = 0
        prev = 0
        
        for char in reversed(s):
            num = roman_map[char]
            if num < prev:
                ans -= num
            else:
                ans += num
            prev = num
            
        return ans
