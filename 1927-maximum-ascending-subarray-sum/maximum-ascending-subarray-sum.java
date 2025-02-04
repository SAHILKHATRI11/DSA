class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0] ;
        int max = nums[0];
        int n = nums.length;
        for(int i = 1;i < n;i++){
            if(nums[i]>nums[i-1]){
                sum += nums[i];
            }
            else{
                sum = nums[i];
            }
            max = Math.max(sum,max);
        }
        return max;
    }
}