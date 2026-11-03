class Solution:
    def minMoves(self, nums: List[int]) -> int:
        moves = 0;
        maxx = max(nums)
        for num in nums:
            moves += maxx-num
        return moves;