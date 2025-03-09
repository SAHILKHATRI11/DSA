class Solution {
    public int numberOfAlternatingGroups(int[] colorsCopy, int k) {
        // 3 <= colors.length <= 100000
        // 0 <= colors[i] <= 1
        // 3 <= k <= colors.length
        int n = colorsCopy.length;
        int colors[] = new int[n + k - 1];
        int left = 0;
        int right = 1;
        for(int i = 0;i < n;i++){
            colors[i] = colorsCopy[i];
            if(i + n < colors.length)
            colors[i + n] = colorsCopy[i];
        }

        int answer = 0;
        while(left < n && right < n + k - 1){
            while(colors[right] != colors[right - 1] && right - left + 1 < k){
                right++;
            }
            if(colors[right] == colors[right - 1]){
                left = right;
                right++;
            }
            else if(right - left + 1 == k){
                answer++;
                left++;
                right++;
                }
            
        }
        return answer;
    }
}