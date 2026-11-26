class Solution {
public:
    bool canAliceWin(int n) {
        bool val = true;
        int diff = 10;
        while(n>=0)
        {
            if(val)
            {
                val = false;
            }
            else
            {
                val = true;
            }
                n-=diff;
                diff--;
        }
        return val;
    }
};