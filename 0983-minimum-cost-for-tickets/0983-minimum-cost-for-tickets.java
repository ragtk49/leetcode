class Solution {
    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        return helper(days, costs, 0);
    }
    
    private int helper(int[] days, int[] costs, int day){
if(day >= days.length) return 0;
        //return previously calculated day
        if(dp[day] != 0) return dp[day];
         int i;
        
        //Attempt to buy a one-day ticket
        int buyOneDay =  helper(days, costs, day + 1) + costs[0];

        //Attempt to buy a seven-day ticket and skip all days that will be included in this ticket
        for(i = day; i < days.length; i++)
            if(days[i] >= days[day] + 7) break;
        int buySevenDays = helper(days, costs, i) + costs[1];
        
        //Attempt to buy a thirty-day ticket and skip all days that will be included in this ticket
        for(i = day; i < days.length; i++)
            if(days[i] >= days[day] + 30) break;
        int buyThirtyDays = helper(days, costs, i) + costs[2];
        
        //return minimum of three options
        int result = Math.min(Math.min(buyOneDay, buySevenDays), buyThirtyDays);
        dp[day] = result;
        return result;
}
}