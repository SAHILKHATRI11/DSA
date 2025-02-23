class TrieNode{
    TrieNode children[];
    int index;
    List<Integer> list;
    TrieNode(){
        children = new TrieNode[26];
        index = -1;
        list = new ArrayList<>();
    }
}
class Solution {
    public boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else
            return false;
        }
        return true;
    }
    public void insert(String s,TrieNode root,int index){
        TrieNode curr = root;
        for(int i = s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            if(isPalindrome(s,0,i) == true){
                curr.list.add(index);
            }
            curr = curr.children[c - 'a'];
        }
        curr.index = index;
        curr.list.add(index);
        
    }
    public void search(String s,TrieNode root,List<List<Integer>> ans,int i){
        TrieNode curr = root;
        int n = s.length()-1;
        for(int j = 0;j<=n;j++){
            if(curr.index >=0 && curr.index!=i && isPalindrome(s,j,n)){
                ans.add(Arrays.asList(i,curr.index));
            }
            char c = s.charAt(j);
            curr = curr.children[c - 'a'];
            if(curr == null){
                return;
            }
        }
        for(int l:curr.list){
            if(i == l)continue;
            ans.add(Arrays.asList(i,l));
        }
        return;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            insert(words[i],root,i);
        }
        for(int i = 0;i<words.length;i++){
            search(words[i],root,answer,i);
        }
        return answer;
    }
}