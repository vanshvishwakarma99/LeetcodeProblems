public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int curr = nums2[i];

            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                map.put(curr, stack.peek());
            } else {
                map.put(curr, -1);
            }

            stack.push(curr);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
