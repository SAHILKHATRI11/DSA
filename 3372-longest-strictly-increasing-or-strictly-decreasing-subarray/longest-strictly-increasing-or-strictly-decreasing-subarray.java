class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int count = 1;
        int max = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                continue;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                continue;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}