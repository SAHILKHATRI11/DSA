class Solution {
    public long countBadPairs(int[] nums) {
        long answer  = 0;
        int n = nums.length;
        Map<Integer,Long> count = new HashMap<>();
        for(int i = 0;i<n;i++){
            int current = nums[i] - i;
            count.put(current,count.getOrDefault(current,0L)+1);
        }
        long goodPairs = 0;
        for(Map.Entry<Integer,Long> entry:count.entrySet()){
            long val = entry.getValue();
            goodPairs += val*(val-1)/2;
        }
        long total = (long)n*(n-1)/2;
        answer =  total - goodPairs;
        return answer;
    }
}