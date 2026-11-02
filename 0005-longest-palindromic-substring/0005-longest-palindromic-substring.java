class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) { 
                int l = i, r = i + j;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > maxLen) {
                        start = l;
                        maxLen = r - l + 1;
                    }
                    l--;
                    r++;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
