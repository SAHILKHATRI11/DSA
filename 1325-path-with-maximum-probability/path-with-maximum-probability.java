class Pair{
    int index;
    double val;
    Pair(int index,double val){
        this.index = index;
        this.val = val;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.val , a.val));
        double distance[] = new double[n];
        Arrays.fill(distance,Double.MIN_VALUE);
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int j = 0;
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new Pair(v,succProb[j]));
            adj.get(v).add(new Pair(u,succProb[j]));
            j++;
        }
        distance[start_node] = 1;
        pq.offer(new Pair(start_node,1));

        while(!pq.isEmpty()){
            Pair currentPair = pq.poll();
            int source = currentPair.index;
            double prob = currentPair.val; 
            if(source == end_node)return distance[end_node];
            if(prob < distance[source])continue;
            for(Pair it : adj.get(source)){
                int node  = it.index;
                double sucProb = it.val;
                if(distance[node] < prob * sucProb){
                    distance[node] = prob * sucProb;
                    pq.offer(new Pair(node,distance[node]));
                }
            }
        }
        return distance[end_node] == Double.MIN_VALUE?0:distance[end_node];
    }
}