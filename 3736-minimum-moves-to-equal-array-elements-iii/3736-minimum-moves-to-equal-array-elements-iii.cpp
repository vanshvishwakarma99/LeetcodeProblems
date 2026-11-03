class Solution {
public:
    int minMoves(vector<int>& nums) {
        int moves = 0;
        int maxx = nums[0];
        int n = nums.size();
        for(int i=1;i<n;i++)
        {
            maxx=max(maxx,nums[i]);
        }
        for(int i=0;i<n;i++)
        {
            moves+=abs(maxx-nums[i]);
        }
        return moves;
    }
};