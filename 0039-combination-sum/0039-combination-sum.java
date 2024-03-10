class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        return helper(candidates, target,0, result, new ArrayList<>());
    }
    
    private List<List<Integer>> helper(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> list){
        //base
        if(index == candidates.length){
            if(target == 0){
                result.add(new ArrayList(list));
            }
            return result;
        }
        
        if(candidates[index] <= target){
            list.add(candidates[index]);
            helper(candidates, target - candidates[index], index, result, list);
            list.remove(list.size() - 1);
        }
        
        helper(candidates, target, index + 1, result, list);
        
        return result;
    }
}
