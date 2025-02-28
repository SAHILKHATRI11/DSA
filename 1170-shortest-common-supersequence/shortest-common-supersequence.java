class Solution {
    public String lcs(String s1, String s2, int index1, int index2, String dp[][]) {
        if (index1 >= s1.length() || index2 >= s2.length()) {
            return "";
        }
        if (dp[index1][index2] != null)
            return dp[index1][index2];
        if (s1.charAt(index1) == s2.charAt(index2)) {
            return dp[index1][index2] = s1.charAt(index1) + lcs(s1, s2, index1 + 1, index2 + 1, dp);
        } else {
            String compare1 = lcs(s1, s2, index1 + 1, index2, dp);
            String compare2 = lcs(s1, s2, index1, index2 + 1, dp);
            dp[index1][index2] = compare1.length() > compare2.length() ? compare1 : compare2;
            return dp[index1][index2];
        }

    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        StringBuilder answer = new StringBuilder();
        String dp[][] = new String[l1 + 1][l2 + 1];
        String longest = lcs(str1, str2, 0, 0, dp);
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < longest.length()) {
            while (i < str1.length() && str1.charAt(i) != longest.charAt(k)) {
                answer.append(str1.charAt(i));
                i++;
            }
            while (j < str2.length() && str2.charAt(j) != longest.charAt(k)) {
                answer.append(str2.charAt(j));
                j++;
            }

            answer.append(longest.charAt(k));
            i++;
            j++;
            k++;
        }
        while (i < str1.length()) {
            answer.append(str1.charAt(i));
            i++;
        }
        while (j < str2.length()) {
            answer.append(str2.charAt(j));
            j++;
        }
        return answer.toString();
    }
}