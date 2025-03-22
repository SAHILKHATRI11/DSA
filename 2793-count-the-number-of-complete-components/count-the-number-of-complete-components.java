class Solution {
    
    class Count {
        int v = 0;
        int e = 0;
    }
    
    public void dfs(boolean[] visited, int node, ArrayList<ArrayList<Integer>> list, Count count) {
        visited[node] = true;
        count.v++;  
        count.e += list.get(node).size(); 
        
        for (int next : list.get(node)) {
            if (!visited[next]) {
                dfs(visited, next, list, count);
            }
        }
    }
    
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Count count = new Count();
                dfs(visited, i, list, count);
                int edgeCount = count.e / 2;  

                
                if (count.v * (count.v - 1) / 2 == edgeCount) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
