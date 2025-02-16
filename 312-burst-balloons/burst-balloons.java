class Solution {
    public int dfs(int nums[], int l, int r, int[][] dp) {
        if (l > r)
            return 0;
        if (dp[l][r] != 0)
            return dp[l][r];
            dp[l][r] = 0;
        for (int i = l; i <= r; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1] + dfs(nums, i + 1, r, dp) + dfs(nums, l, i - 1, dp);
            dp[l][r] = Math.max(coins, dp[l][r]);
        }
        return dp[l][r];
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int nums1[] = new int[n + 2];
        nums1[0] = 1;
        nums1[n + 1] = 1;
        int dp[][] = new int[n + 2][n + 2];
        System.arraycopy(nums,0,nums1,1,n);
        return dfs(nums1, 1, nums1.length - 2, dp);
    }
}