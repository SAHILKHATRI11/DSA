class Solution {
    public String clearDigits(String s) {
        StringBuilder res=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++)
            {
                
                if(Character.isLetter(s.charAt(i)))
                {
                    res.append(s.charAt(i));
                }
                else if(Character.isDigit(s.charAt(i)))
                {
                    if(res.length()>0)
                    res.deleteCharAt(res.length()-1);
                }
                
            }
        return res.toString();
    }
}