class Solution {
    public int uniqueXorTriplets(int[] nums) {
       int i = 0;
       if(nums.length <= 2)return nums.length;
       while(Math.pow(2,i) < nums.length){
        i++;
       }
       if(nums.length % (int)Math.pow(2,i) == 0) return (int)Math.pow(2,i+1);
       return (int)Math.pow(2,i);
    }
}