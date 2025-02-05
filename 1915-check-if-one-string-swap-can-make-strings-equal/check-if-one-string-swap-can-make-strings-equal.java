class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        int count = 0;
        int check1 = 0;
        int check2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if (a != b) {
                count++;
                if (count > 2)
                    return false;
                else if (count == 1) {
                    check1 = i;
                } else
                    check2 = i;
            }
        }
        if (s1.charAt(check1) == s2.charAt(check2) && s1.charAt(check2) == s2.charAt(check1))
            return true;
        return false;
    }
}