class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;
        boolean found = false;

        for (int size = l; size <= r; size++) {
            int sum = 0;

            for (int i = 0; i < size; i++) {
                sum = sum + nums.get(i);
            }

            if (sum > 0) {
                if (sum < minSum) {
                    minSum = sum;
                }
                found = true;
            }

            for (int i = size; i < n; i++) {
                sum = sum + nums.get(i) - nums.get(i - size);

                if (sum > 0) {
                    if (sum < minSum) {
                        minSum = sum;
                    }
                    found = true;
                }
            }
        }

        if (found == false) {
            return -1;
        }

        return minSum;
    }
}