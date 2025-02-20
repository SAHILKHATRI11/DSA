class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int diagonal = 0;
        int n = nums.length;
        StringBuilder ans = new StringBuilder();
        for(String s:nums){
            if(s.charAt(diagonal) == '1')ans.append('0');
            else
            ans.append('1');
            diagonal++;
        }
        return ans.toString();
    }
}