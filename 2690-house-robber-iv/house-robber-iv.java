class Solution {
    public boolean solve(int mid,int k,int nums[]){
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] <= mid){
                count++;
                i++;
                if(count >= k)return true;
            }
        }
        return false;
    }
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(left > nums[i])
            left = nums[i];
            if(right < nums[i])right = nums[i];
        }
        int answer = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(solve(mid,k,nums) == true){
                answer = Math.min(answer,mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return answer;
    }
}