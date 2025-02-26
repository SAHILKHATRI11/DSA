class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int prev = 0;
        int maxPos = 0;
        int maxNeg = 0;
        int answer = 0;
      for(int i = 0;i<nums.length;i++){
        nums[i] += prev;
        prev = nums[i];
      }  
      for(int i = 0;i<nums.length;i++){
        int check1 = Math.abs(nums[i] - maxPos);
        int check2 = Math.abs(nums[i] - maxNeg);
        answer = Math.max(Math.max(check1,check2),answer);
        if(nums[i] > maxPos)maxPos = nums[i];
        if(nums[i] < maxNeg)maxNeg = nums[i];
      }
      return answer;
    }
}