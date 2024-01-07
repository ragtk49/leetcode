class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        HashMap<Long, Integer>[] dp = new HashMap[nums.length];
        for (int i = 0; i < nums.length; ++i) dp[i] = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                int cnt = dp[j].getOrDefault(diff, 0);
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + cnt + 1);
                ans += cnt;
            }
        }
        return ans;
    }
}