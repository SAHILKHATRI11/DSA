class Pair{
    int a;
    int b;
    Pair(int a,int b){
        this.a = a;
        this.b = b;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Character,Integer> map = new HashMap<>();
        int answer = 0;
        Queue<Pair> q = new LinkedList<>();
        for(char a:tasks){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            pq.offer(entry.getValue());
        }
        while(!pq.isEmpty() || !q.isEmpty()){
            answer += 1;
            if(!pq.isEmpty()){
                int currCount = pq.poll() - 1;
                if(currCount > 0)
                q.offer(new Pair(currCount,answer + n));
            }
            if(!q.isEmpty()){
                if(q.peek().b == answer){
                    pq.offer(q.poll().a);
                }
                else{
                    continue;
                }
            }
        }
        return answer;
    }
}