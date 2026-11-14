class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum = sum + nums.get(j);
                int length = j - i + 1;

                if (length >= l && length <= r) {
                    if (sum > 0) {
                        if (sum < minSum) {
                            minSum = sum;
                        }
                        found = true;
                    }
                }
            }
        }

        if (found == false) {
            return -1;
        }

        return minSum;
    }
}
