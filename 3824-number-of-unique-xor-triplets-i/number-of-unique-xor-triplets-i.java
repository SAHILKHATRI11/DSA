class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int ans = nums.length;
        if(ans < 3)return ans;
        int count = 0;
        while(ans > 0){
            ans >>= 1;
            count++;
        }
        return (int)Math.pow(2,count);
    }
}