class Solution {
    public long coloredCells(int n) {
        if(n == 1)return 1;
        long answer =  1;
        int inc = 4;
        for(int i = 2;i<=n;i++){
            answer += inc;
            inc += 4;
        }
        return answer;
    }
}