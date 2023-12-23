class Solution {
    public boolean isPathCrossing(String path) {
        HashMap<Character, int[]> map = new HashMap();
        
        map.put('N', new int[]{0,1});
        map.put('S', new int[]{0,-1});
        map.put('W', new int[]{-1,0});
        map.put('E', new int[]{1,0});
        
        char[] chars = path.toCharArray();
        int x = 0;
        int y = 0;
        String pos = x + "," + y;
        boolean passed = false;
        HashSet<String> set = new HashSet();
        set.add(pos);
        for(int i= 0; i < chars.length; i++){
            int[] dir = map.get(chars[i]);
            x += dir[0];
            y += dir[1];
            String temp = x + "," + y;
            if(set.contains(temp)){
                return true;
            }
            set.add(temp);
        }
        return false;
    }
}