class Solution {
    public int maxProduct(int[] nums) {
       int n = nums.length;
       int max = 1;
       int min = 1;
       int answer = Integer.MIN_VALUE;
       for(int i = 0;i<n;i++){
        answer = Math.max(nums[i],answer);
       }
       for(int i = 0;i<n;i++){
        int tempMax = max;
        max = Math.max(min*nums[i],Math.max(max*nums[i],nums[i]));
        min = Math.min(tempMax*nums[i],Math.min(min*nums[i],nums[i]));
        answer = Math.max(max,answer);
       } 
       return answer;
    }
}
