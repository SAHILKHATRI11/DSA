class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double time[] = new double[dist.length];
        for(int i = 0;i< dist.length;i++){
            time[i] = dist[i] * 1.0/ speed[i];
        }
        Arrays.sort(time);
        int count = 1;
        int ans = 1;
        for(int i = 1;i<dist.length;i++){
            time[i] -= count;
            if(time[i] > 0)ans++;
            else
            return ans;
            count++;
        }
        return ans;
    }
}