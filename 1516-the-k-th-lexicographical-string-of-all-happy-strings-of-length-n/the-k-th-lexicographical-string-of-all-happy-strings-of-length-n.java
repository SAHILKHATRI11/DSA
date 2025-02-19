class Solution {
    List<String> list = new ArrayList<>();
    public void solve(String s,int n,int k){
        if(s.length() == n){
            list.add(s);
            return;
        }
        StringBuilder curr = new StringBuilder(s);
        for(char ch = 'a';ch<='c';ch++){
            if(s.length()>0 && s.charAt(s.length()-1) == ch)continue;
            curr.append(ch);
            s = curr.toString();
            solve(s,n,k);
            curr.deleteCharAt(curr.length()-1);
            s = curr.toString();
        }
        return;
    }
    public String getHappyString(int n, int k) {
        solve("",n,k);
        if(list.size() < k)return "";
        return list.get(k-1);
    }
}