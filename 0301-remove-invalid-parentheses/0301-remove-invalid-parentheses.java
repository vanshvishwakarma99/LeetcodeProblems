class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> queue = new LinkedList<>(List.of(s));
        Set<String> visited = new HashSet<>(queue);
        boolean found = false;

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            
            if (isValid(curr)) {
                ans.add(curr);
                found = true;
            }
            
            if (found) continue;

            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) != '(' && curr.charAt(i) != ')') continue;
                String next = curr.substring(0, i) + curr.substring(i + 1);
                if (visited.add(next)) queue.add(next);
            }
        }
        return ans;
    }

    private boolean isValid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
