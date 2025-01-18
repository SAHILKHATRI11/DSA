class Solution {
    public int minCost(int[][] grid) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int direction[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int distance[][] = new int[grid.length][grid[0].length];

        for (int arr[] : distance) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        distance[0][0] = 0;
        pq.offer(new int[] { 0, 0, 0 });
        int min = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currDis = current[0];
            int i = current[1];
            int j = current[2];
            if (currDis != distance[i][j])
                continue;

            for (int k = 0; k < 4; k++) {
                int row = i + direction[k][0];
                int col = j + direction[k][1];
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                    if (k + 1 == grid[i][j]) {
                        min = 0;
                    } else
                        min = 1;

                    if (distance[row][col] > distance[i][j] + min) {
                        distance[row][col] = distance[i][j] + min;
                        pq.offer(new int[] { distance[row][col], row, col });
                    }
                }
            }
        }
        return distance[grid.length - 1][grid[0].length - 1];
    }
}