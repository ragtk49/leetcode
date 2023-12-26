class Solution {
    final int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] cache = new Integer[n+1][target+1];
        return numOfWays(cache, n, target, k);
    }
    
    private int numOfWays(Integer[][] cache, int dice, int target, int k){
        if(dice == 0){
            return target == 0 ? 1 : 0; 
        }
        
        int ways = 0;
        
        if(cache[dice][target] != null){
            return cache[dice][target];
        }
        
        for(int i = 1; i <= k; i++){
            if(target - i >= 0) {
                ways = (ways + numOfWays(cache, dice - 1, target - i, k)) % MOD;
            }
        }
        cache[dice][target] = ways;
        return ways;
    }
}