class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, results, new ArrayList<>(), 0);
        return results;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> results, List<Integer> combination, int start) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break; // further values will also be greater
            }
            combination.add(candidates[i]);
            backtrack(candidates, target - candidates[i], results, combination, i); // not i + 1 because we can reuse same elements
            combination.remove(combination.size() - 1); // backtrack
        }
    }
}