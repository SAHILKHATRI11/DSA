class Solution {
    int directions[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int dfs(int idCount,int [][]grid,int i,int j,boolean[][] visited){
        if(i < 0 || j >= grid.length || i >= grid.length || j < 0 || visited[i][j] || grid[i][j]!=1){
            return 0;
        }
        visited[i][j] = true;
        grid[i][j] = idCount;
        int area  = 1;
        for(int dir[]:directions){
            int row = i + dir[0];
            int col = j + dir[1];
            area +=dfs(idCount,grid,row,col,visited);
        }
        return area;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int idCount = 2;
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        boolean visited[][] = new boolean[n][n];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0;j < grid.length ; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    map.put(idCount,dfs(idCount,grid,i,j,visited));
                    max = Math.max(max,map.get(idCount));
                    idCount++;
                }
            }

        }
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0;j < grid.length ; j++){
                if(grid[i][j] == 0){
                    int currCount = 1;
                    Set<Integer> set = new HashSet<>();
                    for(int dir[]:directions){
                        int row  = i + dir[0];
                        int col = j + dir[1];
                        if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] != 0)
                        set.add(grid[row][col]);
                    }
                    for(int id : set){
                        currCount += map.getOrDefault(id,0); 
                    }
                    max = Math.max(max,currCount);
                }
            }
        }
        return max;
    }
}