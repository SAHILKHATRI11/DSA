class Solution {
    public long coloredCells(int n) {
        long answer =  0;
        
        for(int i = 1;i<n;i++){
            answer = answer + 4*i;
        }
        return answer + 1;
    }
}