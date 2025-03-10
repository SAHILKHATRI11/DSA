class Pair{
    int val;
    int index;
    Pair(int index,int val){
        this.index = index;
        this.val = val;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //1 <= k <= n <= 100
        // 1 <= u,v <= n
        // u != v
        // 0 <= w <= 100
        // all pairs of u and v are unique
        ArrayList<ArrayList<Pair>> adj  = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> (a.val - b.val));
        int distance[] = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k - 1] = 0;
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int time[] : times){
            int source = time[0];
            int dest = time[1];
            int t = time[2];
            adj.get(source - 1).add(new Pair(dest - 1,t));
        }

        pq.offer(new Pair(k - 1,0));
        while(!pq.isEmpty()){
            Pair currentPair = pq.poll();
            int source = currentPair.index;
            int wt = currentPair.val;
            for(Pair it : adj.get(source)){
                int currentIndex = it.index;
                int weight = it.val;
                if(distance[currentIndex] > weight + wt){
                    distance[currentIndex] = weight + wt;
                    pq.offer(new Pair(currentIndex,distance[currentIndex]));
                }
            }
        }
        Arrays.sort(distance);
        if(distance[distance.length - 1] != Integer.MAX_VALUE)return distance[distance.length - 1];
        return -1;
    }
}