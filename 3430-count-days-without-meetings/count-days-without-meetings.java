class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        
        int maxEnd = 0;
        int freeDays = 0;
        
        for (int[] meeting : meetings) {
            if (meeting[0] > maxEnd) {
                freeDays += meeting[0] - maxEnd - 1;
            }
            
            maxEnd = Math.max(maxEnd, meeting[1]);
        }
        
        if (maxEnd < days) {
            freeDays += days - maxEnd;
        }
        
        return freeDays;
    }
}