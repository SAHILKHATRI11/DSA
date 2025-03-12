class Solution {
    public int maximumCount(int[] nums) {
        int answer = nums.length ;
        int countZero = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > 0){
                answer = Math.max(i - 0 - countZero, nums.length - i);
                return answer;
            }
            if(nums[i] == 0)countZero++;
        }
        return answer - countZero;
    }
}