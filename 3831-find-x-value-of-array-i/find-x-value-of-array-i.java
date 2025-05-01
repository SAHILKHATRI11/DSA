class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long answer[] = new long[k];
        long count[][] = new long[n][k];
        int prev = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (count[prev][j] > 0) {
                    long prod = (long) j * nums[i];
                    int rem = (int) (prod % k);
                    count[i][rem] += count[prev][j];

                }

                if (nums[i] % k == j) {
                    count[i][j]++;
                }
            }
            prev = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                answer[j] += count[i][j];
            }
        }
        return answer;
    }
}