class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder ans = new StringBuilder();
        int currentIndex = 0;
        while(currentIndex < s.length()){
            ans.append(s.charAt(currentIndex));
            currentIndex++;
            if(ans.length()>=part.length()){
                int index = ans.length()-part.length();
                String check = ans.substring(index,ans.length());
                if(check.equals(part)) ans.delete(index, ans.length());
            }
        }
        return ans.toString();
    }
}