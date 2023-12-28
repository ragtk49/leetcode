class Solution {
    public int climbStairs(int n) {
        if(n < 4) return n;
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 2;
        cache[2] = 3;
        for(int i = 3; i <= n; i++){
             cache[i] = cache[i-1] + cache[i-2];
        }
        
        return cache[n-1];
    }
}