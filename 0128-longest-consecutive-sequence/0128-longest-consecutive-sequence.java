class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int maxLen = 0;
        for (int num : nums) {
            // Skip if this number isn't the start of a sequence
            if (!set.contains(num - 1)) {
                set.remove(num); // remove the current number from the set
                int currentStreak = 1;

                while (set.contains(num + currentStreak)) {
                    set.remove(num + currentStreak); // remove the number from the set
                    currentStreak++;
                }

                maxLen = Math.max(maxLen, currentStreak);
            }
        }
        return maxLen;

    }
}