class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        int target=0;
        if(totalSum%2==0)target=totalSum/2;
        else return false;
        boolean dp[][]=new boolean[n+1][target+1];
        for(int i=0;i<=target;i++){
            dp[0][i]=false;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(nums[i-1]<=j)
                dp[i][j]=dp[i-1][j-nums[i-1]]||dp[i-1][j];
                else
                dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][target];
    }
}