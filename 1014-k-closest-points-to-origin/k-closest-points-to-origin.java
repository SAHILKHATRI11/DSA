class Pair{
    int index;
    double val;
    Pair(int index,double val){
        this.index = index;
        this.val = val;
    }
}
class Solution {
    public double calc(int x,int y){
        double check = Math.pow(x,2) + Math.pow(y,2);
        double ans = Math.sqrt(check);
        return ans;
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(a.val,b.val));
        int [][]answer = new int[k][2];
        for(int i = 0;i<points.length;i++){
            double root = calc(points[i][0],points[i][1]);
            pq.offer(new Pair(i,root));
        }
        for(int i = 0;i<k;i++){
            Pair current = pq.poll();
            int index = current.index;
            answer[i][0] = points[index][0];
            answer[i][1] = points[index][1];
        }
        return answer;
    }
}