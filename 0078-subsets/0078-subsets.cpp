class Solution {
    private:
    vector<vector<int>>ans;
    void generateSubset(vector<int>&nums, int index,vector<int>current)
    {
        if(nums.size() == index)
        {
            ans.push_back(current);
            return;
        }
        current.push_back(nums[index]); // store
        generateSubset(nums,index+1,current); // explore
        current.pop_back(); // undo
        generateSubset(nums,index+1,current); // explore
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> current;
        generateSubset(nums,0,current);
        return ans;
    }
};