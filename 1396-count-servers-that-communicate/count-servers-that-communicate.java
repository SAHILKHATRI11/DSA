class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int countRows[] = new int[n];
        int countCols[] = new int[m];
        int notConnected  = 0;
        int totalCount = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    countCols[j]++;
                    countRows[i]++;
                    totalCount++;
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1 && countCols[j]==1 && countRows[i]==1){
                    notConnected++;
                }
            }
        }
        return totalCount - notConnected;
    }
}