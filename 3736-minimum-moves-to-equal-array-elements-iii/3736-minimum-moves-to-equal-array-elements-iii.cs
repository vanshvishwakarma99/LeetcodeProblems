public class Solution {
    public int MinMoves(int[] nums) {
        int n = nums.Length;
            int maxx = nums[0];
    for(int i=1;i<n;i++)
    {
        if(nums[i]>maxx) maxx = nums[i];
    }

    int moves =0 ;
    for(int i=0;i<n;i++)
    {
        moves += maxx - nums[i];
    }

    return moves;
    }
}