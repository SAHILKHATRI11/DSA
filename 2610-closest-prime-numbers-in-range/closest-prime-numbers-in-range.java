class Solution {
    public int[] closestPrimes(int left, int right) {
        // range 1 <= left <= right <= 1000000
        boolean visited[] = new boolean[right + 1];
        Arrays.fill(visited,true);
        visited[1] = false;
        for(int i = 2 ; i*i <= right ;i++){
            if(visited[i] == true){
                for(int j = i*i; j <= right ;j+=i){
                    visited[j] = false;
                }
            }
        }

        int prev = -1;
        int diff = Integer.MAX_VALUE;
        int ans[] = new int[2];
        Arrays.fill(ans,-1);
        for(int i = left ;i <= right;i++){
            if(visited[i] != false && prev == -1){
                prev = i;
            }
            else if(visited[i] != false && diff > i - prev){
                diff = i - prev;
                ans[0] = prev;
                ans[1] = i;
                prev = i;
            }
            else if(visited[i]!=false){
                prev = i;
            }
        }
        return ans;
    }
}