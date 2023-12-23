class Solution {
    public boolean isPathCrossing(String path) {
        char[] chars = path.toCharArray();
        int x = 0;
        int y = 0;
        String pos = x + "," + y;
        boolean passed = false;
        HashSet<String> set = new HashSet();
        set.add(pos);
        for(int i= 0; i < chars.length; i++){
            if(chars[i] == 'N'){
                 y += 1;
                 String temp = x + "," + y;
                 if(set.contains(temp)){
                    return true;
                 }
                 set.add(temp);
            }
            if(chars[i] == 'S'){
                 y += -1;
                 String temp = x + "," + y;
                 if(set.contains(temp)){
                    return true;
                 }
                 set.add(temp);
            }
            if(chars[i] == 'W'){
                 x += -1;
                 String temp = x + "," + y;
                 if(set.contains(temp)){
                    return true;
                 }
                 set.add(temp);
            }
            if(chars[i] == 'E'){
                 x += 1;
                 String temp = x + "," + y;
                 if(set.contains(temp)){
                    return true;
                 }
                 set.add(temp);
            }
        }
        return false;
    }
}