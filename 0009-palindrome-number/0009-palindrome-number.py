class Solution:
    def isPalindrome(self, x: int) -> bool:
        s = str(x)
        left, right = 0, len(s) - 1
        
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
            
        return True



# class Solution:
#     def isPalindrome(self, x: int) -> bool:
#         if x < 0:
#             return False

#         n = x
#         rev_num = 0

#         while n > 0:
#             d = n % 10
#             rev_num = rev_num * 10 + d
#             n = n // 10 

#         return rev_num == x
