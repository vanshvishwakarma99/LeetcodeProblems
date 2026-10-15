class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}


/*
class Solution {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }

        int n = x;
        int revNum = 0;

        while(n>0){
            int d = n%10;
            revNum = revNum*10 + d;
            n = n/10;
        }

        if (revNum == x){
            return true;
        }
        else{
            return false;
        }
    }
}
*/