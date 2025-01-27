class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] p, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        int []inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list from prerequisites
        for (int[] prereq : p) {
            int u = prereq[0];
            int v = prereq[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        //ab topo sorting 
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            mp.put(i, new HashSet<>());
        }
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int next : adj.get(curr)) {
                mp.get(next).add(curr);
                mp.get(next).addAll(mp.get(curr));
                inDegree[next]--;
                if(inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries) {
            res.add(mp.get(query[1]).contains(query[0]));
        }
        return res;

    }
}