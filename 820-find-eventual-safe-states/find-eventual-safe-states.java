//first method:dfs se
//second method:topological sort bfs/kahn's algorithm   
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        ArrayList<List<Integer>> adj=new ArrayList<>();
        List<Integer> answer=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int indegree[]=new int[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int node:graph[i])
            {
                adj.get(node).add(i);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int node:adj.get(i))
            {
                indegree[node]++;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            q.offer(i);
        }
        while(!q.isEmpty())
        {
            int parent=q.peek();
            answer.add(q.poll());
            for(int node:adj.get(parent))
            {
                indegree[node]--;
                if(indegree[node]==0)
                q.offer(node);
            }
        }
        Collections.sort(answer);
        return answer;
    }
}