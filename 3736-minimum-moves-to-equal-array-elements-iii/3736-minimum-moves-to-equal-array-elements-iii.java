class Solution {
    public int minMoves(int[] nums) {
        int maxx = nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++)
        {
            maxx = Math.max(maxx,nums[i]);
        }
        int moves = 0;
        for(int i=0;i<n;i++)
        {
            moves+=maxx-nums[i];
        }
        return moves;
    }
}