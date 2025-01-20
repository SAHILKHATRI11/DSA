class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int rowCount[] = new int[m];
        int colCount[]  = new int[n];
        Map<Integer,Pair> map = new HashMap<>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j < n ;j++){
                map.put(mat[i][j],new Pair(i,j));
            }
        }
        for(int k=0;k<arr.length;k++){
            Pair current = map.get(arr[k]);
            int r = current.i;
            int c = current.j;
            rowCount[r]++;
            colCount[c]++;
            if(rowCount[r]==n||colCount[c]==m)return k;
        }
        return -1;
    }
}