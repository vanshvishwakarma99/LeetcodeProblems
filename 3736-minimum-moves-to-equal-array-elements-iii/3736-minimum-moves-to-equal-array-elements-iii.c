int minMoves(int* nums, int numsSize) {
    int maxx = nums[0];
    for(int i=1;i<numsSize;i++)
    {
        if(nums[i]>maxx) maxx = nums[i];
    }

    int moves =0 ;
    for(int i=0;i<numsSize;i++)
    {
        moves += maxx - nums[i];
    }

    return moves;
}