class Solution:
    def minMoves2(self, nums: list[int]) -> int:
        nums.sort()
        
        median = nums[len(nums) // 2]
        
        moves = sum(abs(num - median) for num in nums)
        
        return moves

        