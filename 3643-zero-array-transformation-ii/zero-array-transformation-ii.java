class Solution {
    public boolean isZeroArray(int []nums,int[][]interval,int n){
         int sweep[]=new int[nums.length];
        for(int i=0;i<n;i++){
            int left = interval[i][0];
            int right = interval[i][1];
            int val = interval[i][2];
            sweep[left]+=val;
            if((right+1)<sweep.length)sweep[right+1]-=val;
        }
           for(int i=1;i<sweep.length;i++){
            sweep[i]+=sweep[i-1];
           } 
           for(int i=0;i<sweep.length;i++){
            if(sweep[i]<nums[i])return false;
           }
           return true;
    }
    public int minZeroArray(int[] nums, int[][] interval) {
           int ans=-1;
           int left = 0;
           int right=interval.length;
           while(left<=right){
            int mid = left+(right - left)/2;
            if(isZeroArray(nums,interval,mid)){
                right=mid-1;
                ans = mid;
            }
            else{
                left=mid+1;
            }
           }
           return ans;
          
    }
}