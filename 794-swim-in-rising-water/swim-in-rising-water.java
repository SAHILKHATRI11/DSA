class Pair{
    int i;
    int j;
    int val;
    Pair(int i,int j,int val){
        this.i = i;
        this.j = j;
        this.val = val;
    }
}
class Solution {
    public int swimInWater(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int distance[][] = new int[n][m];
        int directions[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.val - b.val));
        for(int dist[] : distance){
            Arrays.fill(dist,Integer.MAX_VALUE);
        }
        distance[0][0] = grid[0][0];
        pq.offer(new Pair(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            Pair currentPair = pq.poll();
            int i = currentPair.i;
            int j = currentPair.j;
            int val = currentPair.val;
            if(i == n-1 && j == m-1)return val;
            if(val > distance[i][j])continue;
            for(int dir[] : directions){
                int newI = dir[0] + i;
                int newJ = dir[1] + j;
                if(newI >= 0 && newI < n && newJ >= 0 && newJ < m){
                    int check = Math.max(val,grid[newI][newJ]);
                    if(distance[newI][newJ] > check){
                        distance[newI][newJ] = check;
                        pq.offer(new Pair(newI,newJ,distance[newI][newJ]));
                    }
                }
            }
        }
        return -1;
    }
}