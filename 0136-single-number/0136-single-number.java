class Solution {
    public int singleNumber(int[] nums) {
        // XOR APPROACH  A^A=0
        int result = 0;
        for(int num : nums){
            result ^= num;
        }
        return result;
    }
}