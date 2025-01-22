class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int directions[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        int height[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair current = q.poll();
            int i = current.i;
            int j = current.j;
            for (int k = 0; k < directions.length; k++) {
                int row = i + directions[k][0];
                int col = j + directions[k][1];
                if (row >= 0 && row < n && col >= 0 && col < m && visited[row][col] != true) {
                    visited[row][col] = true;
                    height[row][col] = height[i][j] + 1;
                    q.offer(new Pair(row, col));
                }
            }
        }
        return height;
    }
}