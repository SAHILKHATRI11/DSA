class Solution {
    public long gridGame(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long preUpper[] = new long[m];
        long preLower[] = new long[m];
        preUpper[0] = grid[0][0];
        preLower[0] = grid[1][0];
        for(int i = 1 ; i < m ; i++){
            preUpper[i] = preUpper[i-1]+grid[0][i];
            preLower[i] = preLower[i-1]+grid[1][i];
        }

        long min = Long.MAX_VALUE;

        for(int i=0;i<m;i++){
            long upperPoints = preUpper[m-1]-preUpper[i];
            long lowerPoints = preLower[i]-grid[1][i];
            long compare = upperPoints>lowerPoints?upperPoints:lowerPoints;
            if(min > compare){
                min = compare;
            }
        }
        return min;
    }
}