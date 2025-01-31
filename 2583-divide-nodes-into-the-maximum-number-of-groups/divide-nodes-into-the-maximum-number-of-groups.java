class Solution {
    public boolean bipartite(List<ArrayList<Integer>> adj, int n) {
        int color[] = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : adj.get(u)) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.offer(v);
                        } else if (color[v] == color[u])
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public int getMaxFromEachPart(List<ArrayList<Integer>> adj, int n, int node, int levels[], boolean visited[]) {
        visited[node] = true;
        int max = levels[node];
        for (int v : adj.get(node)) {
            if (!visited[v]) {
                max = Math.max(max, getMaxFromEachPart(adj, n, v, levels, visited));
            }
        }
        return max;
    }

    public int bfs(List<ArrayList<Integer>> adj, int n, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        boolean visited[] = new boolean[n];
        visited[node] = true;
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int currNode = q.poll();
                for (int v : adj.get(currNode)) {
                    if (visited[v])
                        continue;
                    q.offer(v);
                    visited[v] = true;
                }
                size--;
            }
            level++;
        }
        return level - 1;
    }

    public int magnificentSets(int n, int[][] edges) {
        int answer = 0;
        List<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        if (!bipartite(adj, n))
            return -1;

        // now bfs from every node and give whatever maximum levels are found to the
        // levels array
        int levels[] = new int[n];
        for (int i = 0; i < n; i++) {
            levels[i] = bfs(adj, n, i);
        }
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int componentMax = getMaxFromEachPart(adj, n, i, levels, visited);
                answer += componentMax;
            }
        }
        return answer;
    }
}