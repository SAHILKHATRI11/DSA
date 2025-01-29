class Solution {
    class DSU{
        int N;
        int rank[];
        int parent[];
        public DSU(int N){
            this.N = N;
            rank = new int[N];
            parent =  new int[N];
            for(int i = 0;i < N;i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int[]parent,int node){
            if(parent[node] == node)return node;
            return parent[node] = find(parent,parent[node]);
        }
        public boolean union(int x,int y){
            int xRoot = find(parent,x);
            int yRoot = find(parent,y);
            if(xRoot == yRoot)return false;
            else if(rank[xRoot] < rank[yRoot]){
                parent[xRoot] = yRoot;
            }
            else if(rank[xRoot] > rank[yRoot]){
                parent[yRoot] = xRoot;
            }
            else{
                parent[xRoot] = yRoot;
                rank[yRoot] = rank[yRoot] + 1;
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for(int []edge:edges){
            if(!dsu.union(edge[0]-1,edge[1]-1))
            return edge;
        }
        return new int[]{};
    }
}