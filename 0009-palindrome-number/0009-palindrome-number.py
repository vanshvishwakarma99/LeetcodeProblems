class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False

        n = x
        rev_num = 0

        while n > 0:
            d = n % 10
            rev_num = rev_num * 10 + d
            n = n // 10 

        return rev_num == x
