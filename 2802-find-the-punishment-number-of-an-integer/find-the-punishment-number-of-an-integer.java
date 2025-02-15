class Solution {
    public boolean solve(String s, int sum, int sq, int index,int [][]memo) {
        if (index == s.length()) {
            return sum == sq;
        }
        if (sum > sq) {
            return false;
        }
        if(memo[sum][index]!=-1)return memo[sum][index]==1?true:false;
        for (int i = index; i < s.length(); i++) {
            String add = s.substring(index, i + 1);
            int adNum = Integer.parseInt(add);
            if (solve(s, sum + adNum, sq, i + 1,memo)) {
                memo[sum][index] = 1 ;
                return true;
            }
        }
        memo[sum][index] = 0;
        return false;
    }

    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String s = Integer.toString(square);
            int memo[][] = new int[i+1][s.length()+1];
            for(int mem[]:memo){
                Arrays.fill(mem,-1);
            }
            if (solve(s, 0, i, 0,memo)) {
                sum += square;
            }
        }
        return sum;
    }
}