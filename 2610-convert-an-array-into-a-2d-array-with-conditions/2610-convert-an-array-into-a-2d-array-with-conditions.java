class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if(nums == null) return res;
        HashMap<Integer, Integer> map = new HashMap();
        
        for (int c : nums) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            int currentFreq = map.get(c);

            if (currentFreq > res.size()) {
                res.add(new ArrayList<>());
            }

            // Store the integer in the list corresponding to its current frequency.
            res.get(currentFreq - 1).add(c);
        }

        return res;
    }
}