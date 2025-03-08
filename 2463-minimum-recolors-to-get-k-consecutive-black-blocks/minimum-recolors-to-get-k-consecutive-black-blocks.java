class Solution {
    public int minimumRecolors(String blocks, int k) {
        // 1 <= n <= 100
        // 1 <= k <= n
        int consecutiveBlacks  = 0;
        int whiteCount = 0;
        int blackCount = 0;
        int left = 0;
        int right = k;
        for(int i = 0;i<k;i++){
            if(blocks.charAt(i) == 'W')whiteCount++;
            else blackCount++;
        }
        int answer = whiteCount;
        while(right < blocks.length()){
            if(whiteCount + blackCount == k && answer > whiteCount){
                answer = whiteCount;
            }
            if(blocks.charAt(left) == 'W')whiteCount--;
            else blackCount--;
            if(blocks.charAt(right) == 'W')whiteCount++;
            else
            blackCount++;
            left++;
            right++;
        }
        if(answer > whiteCount)answer = whiteCount;
        return answer;
    }
}