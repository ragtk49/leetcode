class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        
        Queue<Integer> heap = new PriorityQueue<>(
                                (a,b) -> map.get(a) - map.get(b));
        
        for(int num : map.keySet()){
            heap.add(num);
            if(heap.size() > k) heap.poll();
        }
        int top[] = new int[k];
        for(int i = k-1; i >= 0; i--){
            top[i] = heap.poll();
        }
        
        return top;
    }
}