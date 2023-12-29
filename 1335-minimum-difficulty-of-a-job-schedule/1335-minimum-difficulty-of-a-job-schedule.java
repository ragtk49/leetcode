class Solution {
    int[] jobDifficulty;
    int [][] cache;
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.jobDifficulty = jobDifficulty;
        cache = new int[jobDifficulty.length][d+1];
        for(int[] row :cache) Arrays.fill(row, -1);
        if(jobDifficulty.length < d) return -1;
        
        return helper(0, d);
    }
    
    private int helper(int index, int daysRemaining){
        final int N = jobDifficulty.length;
        if(daysRemaining == 0 && index == N) return 0;
        if(daysRemaining == 0 || index == N) return Integer.MAX_VALUE;
        if(cache[index][daysRemaining] != -1) return cache[index][daysRemaining];

        int curMax = jobDifficulty[index];
        int min = Integer.MAX_VALUE;
        for(int schedule = index; schedule < N; ++schedule){
            curMax = Math.max(curMax, jobDifficulty[schedule]);
            int temp = helper(schedule + 1, daysRemaining-1);
            if(temp != Integer.MAX_VALUE)
                min = Math.min(min, temp + curMax);
        }

        return cache[index][daysRemaining] = min;
    }
}