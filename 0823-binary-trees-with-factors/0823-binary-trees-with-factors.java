import java.util.*;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1000000007;
        Arrays.sort(arr);

        Map<Integer, Long> treeCount = new HashMap<>();

        for (int parent : arr) {
            long ways = 1;
            for (int left : arr) {
                if (left >= parent) {
                    break;
                }
                if (parent % left == 0) {
                    int right = parent / left;

                    if (treeCount.containsKey(right)) {
                        ways = ways + (treeCount.get(left) * treeCount.get(right));
                    }
                }
            }
            treeCount.put(parent, ways % MOD);
        }
        long answer = 0;
        for (long count : treeCount.values()) {
            answer = (answer + count) % MOD;
        }
        return (int) answer;
    }
}