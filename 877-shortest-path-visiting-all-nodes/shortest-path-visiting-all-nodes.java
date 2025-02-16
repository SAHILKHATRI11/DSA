class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 0 || n == 1)
            return 0;
        boolean visited[][] = new boolean[n][1 << n];
        Queue<int[]> q = new LinkedList<>();
        int destination = (1 << n) - 1;
        for (int i = 0; i < n; i++) {
            int bitMask = 1 << i;
            visited[i][bitMask] = true;
            q.offer(new int[]{i, bitMask});
        }
        int path = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            path++;
            while (size > 0) {
                int[] currentPair = q.poll();
                int currentNode = currentPair[0];
                int mask = currentPair[1];
                for (int nextNode : graph[currentNode]) {
                    int currentMask = mask | (1 << nextNode);
                    if (currentMask == destination)
                        return path;
                    else if (visited[nextNode][currentMask])
                        continue;
                    q.offer(new int[]{nextNode, currentMask});
                    visited[nextNode][currentMask] = true;
                }
                size--;
            }
        }
        return path;
    }
}