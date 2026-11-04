import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public static long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int numWindows = n - x + 1;
        if (numWindows < 0 || n < x * k) return -1;

        long[] costs = new long[numWindows];
        TreeMap<Integer, Integer> leftMap = new TreeMap<>();
        TreeMap<Integer, Integer> rightMap = new TreeMap<>();
        
        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;
        int targetLeftSize = (x + 1) / 2;

        for (int i = 0; i < n; i++) {
            int newNum = nums[i];
            if (leftSize == 0 || newNum <= leftMap.lastKey()) {
                leftMap.put(newNum, leftMap.getOrDefault(newNum, 0) + 1);
                leftSum += newNum;
                leftSize++;
            } else {
                rightMap.put(newNum, rightMap.getOrDefault(newNum, 0) + 1);
                rightSum += newNum;
                rightSize++;
            }

            if (i >= x) {
                int oldNum = nums[i - x];
                if (leftMap.containsKey(oldNum)) {
                    int prevCount = leftMap.get(oldNum);
                    if (prevCount == 1) leftMap.remove(oldNum);
                    else leftMap.put(oldNum, prevCount - 1);
                    leftSum -= oldNum;
                    leftSize--;
                } else {
                    int prevCount = rightMap.get(oldNum);
                    if (prevCount == 1) rightMap.remove(oldNum);
                    else rightMap.put(oldNum, prevCount - 1);
                    rightSum -= oldNum;
                    rightSize--;
                }
            }

            while (leftSize > targetLeftSize) {
                int val = leftMap.lastKey();
                if (leftMap.get(val) == 1) leftMap.remove(val);
                else leftMap.put(val, leftMap.get(val) - 1);
                leftSum -= val;
                leftSize--;

                rightMap.put(val, rightMap.getOrDefault(val, 0) + 1);
                rightSum += val;
                rightSize++;
            }

            while (leftSize < targetLeftSize && rightSize > 0) {
                int val = rightMap.firstKey();
                if (rightMap.get(val) == 1) rightMap.remove(val);
                else rightMap.put(val, rightMap.get(val) - 1);
                rightSum -= val;
                rightSize--;

                leftMap.put(val, leftMap.getOrDefault(val, 0) + 1);
                leftSum += val;
                leftSize++;
            }

            if (i >= x - 1) {
                long median = leftMap.lastKey();
                int windowIdx = i - x + 1;
                if (x % 2 == 1) {
                    costs[windowIdx] = rightSum - leftSum + median;
                } else {
                    costs[windowIdx] = rightSum - leftSum;
                }
            }
        }

        long INF = Long.MAX_VALUE / 2;
        long[][] memo = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], INF);
            memo[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                memo[i][j] = memo[i - 1][j];
                if (i >= x) {
                    memo[i][j] = Math.min(memo[i][j], memo[i - x][j - 1] + costs[i - x]);
                }
            }
        }

        return memo[n][k] >= INF ? -1 : memo[n][k];
    }
}
