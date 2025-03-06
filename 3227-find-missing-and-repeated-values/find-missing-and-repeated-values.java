class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int arr[] = new int[n * m];
        int ans[] = new int[2];
        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                arr[index] = grid[i][j];
                index++;
            }
        }
        Arrays.sort(arr);
        int prev = 0;
        for (int i = 0; i < n * m; i++) {
            if (arr[i] == prev) {
                ans[0] = arr[i];
            } else if ((arr[i] - prev) > 1)
                ans[1] = prev + 1;
            prev = arr[i];
        }
        if (ans[1] == 0) {
            ans[1] = arr[n * m - 1] + 1;
        }
        return ans;
    }
}