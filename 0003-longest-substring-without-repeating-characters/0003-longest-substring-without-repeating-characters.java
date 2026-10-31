/*
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            int duplicate = s.indexOf(s.charAt(right), left);

            if(duplicate < right){
                left = duplicate + 1;
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
*/


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
