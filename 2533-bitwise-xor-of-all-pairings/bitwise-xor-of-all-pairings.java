class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int answer1 = 0;
        int answer2 = 0;
        if (len1 % 2 == 0 && len2 % 2 == 0) {
            return 0;
        }
        for (int i = 0; i < len1; i++) {
            answer1 ^= nums1[i];
        }
        for (int i = 0; i < len2; i++) {
            answer2 ^= nums2[i];
        }
        if (len1 % 2 == 0) {
            return answer1;
        } else if (len2 % 2 == 0) {
            return answer2;
        }

        return answer1 ^ answer2;
    }
}