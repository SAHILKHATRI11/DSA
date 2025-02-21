class Pair{
    char a;
    int count;
    Pair(char a,int count){
        this.a = a;
        this.count = count;
    }
}
class Solution {
    public String frequencySort(String s) {
        StringBuilder answer = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(b.count-a.count));
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char a = s.charAt(i);
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }
        while(!pq.isEmpty()){
            int count = pq.peek().count;
            char a = pq.poll().a;
            for(int i = 0;i<count;i++){
                answer.append(a);
            }
        }
        return answer.toString();
    }
}