class Solution {
    public int solve(int i,int j,Map<Integer,Integer> map,int arr[],int dp[][]){
        if(dp[i][j] != -1)return dp[i][j];
        int target = arr[j] - arr[i];
        int index = map.getOrDefault(target,-1);
        if(index!=-1 && index < i){
            return dp[i][j] = 1 + solve(index,i,map,arr,dp);
        }
        return dp[i][j] = 2;
    }
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[arr.length + 1][arr.length + 1];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int answer = 0;
        for(int i = 0;i < n;i++){
            map.put(arr[i],i);
        }
        for(int i = 0;i<n-1;i++){
            for(int j = i + 1;j<n;j++){
                max = solve(i,j,map,arr,dp);
                if(max >= 3)
                answer = Math.max(answer,max);
            }
        }
        return answer;
    }
}