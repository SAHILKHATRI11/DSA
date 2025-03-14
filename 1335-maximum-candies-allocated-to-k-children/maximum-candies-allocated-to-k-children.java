class Solution {
    public boolean isValid(int[] candies, int candiesPerChild, long k) {
        if (candiesPerChild == 0) return true; 
        
        long count = 0;
        for (int c : candies) {
            count += c / candiesPerChild; 
            if (count >= k) return true; 
        }
        return false; 
    }
    
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        if (sum < k) return 0;
        
        int left = 0; 
        int right = (int)Math.min(sum / k, Integer.MAX_VALUE);
        int answer = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(candies, mid, k)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}