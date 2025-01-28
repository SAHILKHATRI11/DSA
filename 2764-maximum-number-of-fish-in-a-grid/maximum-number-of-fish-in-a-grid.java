class Solution {
    public int bfs(int i,int j,int [][]grid,boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;
        int sum  = grid[i][j];
        Queue<int []> q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new int[]{i,j});
        int directions[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int []curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int k = 0;k<directions.length;k++){
                int row = r + directions[k][0];
                int col = c + directions[k][1];
                if(row >= 0 && col >=0 &&row < n && col < m && visited[row][col]!=true && grid[row][col]!=0){
                    visited[row][col]=true;
                    sum+=grid[row][col];
                    q.offer(new int[]{row, col});
                }
            }
        }
        return sum;
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0){
                    max = Math.max(max,bfs(i,j,grid,visited));
                }
            }
        }
        return max;
    }
}