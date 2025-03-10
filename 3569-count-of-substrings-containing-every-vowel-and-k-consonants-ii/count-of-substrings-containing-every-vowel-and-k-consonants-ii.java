class Solution {
    public long countOfSubstrings(String s, int k) {
        Map<Character, Integer> map =new HashMap<>();
        int left=0;
        int right=0;
        int n = s.length();
        int postConsonant[] = new int[n];
        int lastConsonant = n;
        String vowel = "aeiou";
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            postConsonant[i]=lastConsonant;
            if(vowel.indexOf(ch)==-1){
                lastConsonant = i;
            }
        }
        int consonants = 0;
        long ans = 0;
        while(right < n){
            char ch = s.charAt(right);
            if(vowel.indexOf(ch)!=-1){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            else
            consonants++;
            while(left<=right && consonants > k){
                char check = s.charAt(left);
                if(vowel.indexOf(check)==-1)consonants--;
                else
                {
                    map.put(check,map.get(check)-1);
                    if(map.get(check)==0)map.remove(check);
                }
                left++;
            }
            while(left<right&& map.size()==5&&consonants==k){
                ans += postConsonant[right] - right;
                char check = s.charAt(left);
                if(vowel.indexOf(check)==-1)consonants--;
                else
                {
                    map.put(check,map.get(check)-1);
                    if(map.get(check)==0)map.remove(check);
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}