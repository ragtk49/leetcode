class Solution {
    final int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] cache = new Integer[n+1][target+1];
        return numOfWays(cache, 0, n, 0, target, k);
    }
    
    private int numOfWays(Integer[][] cache, int diceIndex, int dice, int currSum, int target, int k){
        if(diceIndex == dice){
            return currSum == target ? 1 : 0; 
        }
        
        if(cache[diceIndex][currSum] != null){
            return cache[diceIndex][currSum];
        }
        
        int ways = 0;
        for(int i = 1; i <= Math.min(k, target - currSum); i++){
            ways = (ways + numOfWays(cache, diceIndex + 1, dice, currSum + i, target, k)) % MOD;
        }
        return cache[diceIndex][currSum] = ways;
    }
}