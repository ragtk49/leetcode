class Solution {
    public int numIslands(char[][] grid) {
        int[][] direction = {{-1,0},{0,-1},{0,1},{1,0}};
        Queue<int[]> queue = new LinkedList();

        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    queue.add(new int[] {i,j});
                    islands = islands + 1;
                    grid[i][j] = '0';

                    while(!queue.isEmpty()){
                        int[] currPos = queue.poll();
                        int currRow = currPos[0];
                        int currCol = currPos[1];

                        for( int[] dir : direction ){
                            int newRow = currRow + dir[0];
                            int newCol = currCol + dir[1];

                            if(newRow >= 0 && newCol >=0 && newRow < m && newCol < n && grid[newRow][newCol] == '1'){
                                queue.add(new int[] {newRow ,newCol});
                                grid[newRow][newCol] = '0';
                            }
                        }
                    }
                }
            }
        }
        return islands;

    }
}