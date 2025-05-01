class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer,int[]> col = new HashMap<>();
        Map<Integer,int[]> row = new HashMap<>();
        int answer = 0;
        for(int i = 0;i < buildings.length;i++){
            int x = buildings[i][0];
            int y = buildings[i][1];
            row.putIfAbsent(x, new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            row.get(x)[0] = Math.min(row.get(x)[0],y);
            row.get(x)[1] = Math.max(row.get(x)[1],y);
            col.putIfAbsent(y, new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            col.get(y)[0] = Math.min(col.get(y)[0],x);
            col.get(y)[1] = Math.max(col.get(y)[1],x);
        }

        for(int building[] : buildings){
            int x = building[0];
            int y = building[1];
            int yMin = row.get(x)[0];
            int yMax = row.get(x)[1];
            int xMin = col.get(y)[0];
            int xMax = col.get(y)[1];
            if(y > yMin && y < yMax && x > xMin && x < xMax){
                answer++;
            }
        }
        return answer;
    }
}