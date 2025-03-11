class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        String contains = "abc";
        int answer = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (contains.indexOf(ch) != -1) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            while (left < right && map.size() == 3) {
                answer++;
                answer += s.length() - right - 1;
                char remove = s.charAt(left);
                if (contains.indexOf(remove) != -1) {
                    map.put(remove, map.get(remove) - 1);
                    if (map.get(remove) == 0)
                        map.remove(remove);
                }
                left++;
            }
            right++;
        }
        return answer;
    }
}