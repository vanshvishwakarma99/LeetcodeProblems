class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        return (s + s).contains(goal);
    }
}


/*
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        int n = s.length();

        for(int i = 1; i<=n; i++){
            String sSub = s.substring(0,i);
            String gSub = goal.substring(n-i, n);

            if(sSub.equals(gSub)){
                if(s.substring(i).equals(goal.substring(0, n-i))){
                    return true;
                }
            }
        }

        return false;
    }
}
*/