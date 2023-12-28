class Solution {
    int[] nums;
    int count;
    int target;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return helper(0, 0);
    }
    private int helper(int index, int sum){
        //base
        if(index > nums.length) return 0;
        if(index == nums.length){
            if(sum == target) count++;
        }
        else{
        //logic
        int add = helper(index + 1, sum + nums[index]);
        int delete = helper(index + 1, sum - nums[index]);
        }
        return count;
    }
}