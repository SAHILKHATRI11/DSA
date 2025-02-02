class Solution {
    public boolean check(int[] nums) {
        //brute force
        int n = nums.length;
        int dupli[] = new int[2*n];

        for(int i = 0;i < n;i++){
            dupli[i] = nums[i];
            dupli[n+i] = nums[i];
        }
        int checkIndex = 0;
        for(int i = 1;i<n;i++){
            if(nums[i]>=nums[i-1]){
                if(i==n-1)return true;
                continue;
                }
            else{
                checkIndex = i-1;
                break;
            }
        }
        for(int i = checkIndex+2;i<checkIndex + n + 1;i++){
            if(dupli[i]>=dupli[i-1])continue;
            else
            return false;
        }
        return true;
    }
}