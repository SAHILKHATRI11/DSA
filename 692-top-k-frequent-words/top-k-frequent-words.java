class Pair{
    String a;
    int count;
    Pair(String a ,int count){
        this.a = a;
        this.count = count;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> answer = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        PriorityQueue<String> pq2 = new PriorityQueue<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
         PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            int aCount = map.get(a);
            int bCount = map.get(b);
            if(aCount == bCount)return a.compareTo(b);
            return bCount - aCount;
        });
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            pq.offer(entry.getKey());
        }
        while(k>0){
           answer.add(pq.poll());
            k--;
        }
        return answer;
    }
}