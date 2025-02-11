class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pas=new ArrayList<>();
        int tables[][] = new int[numRows][numRows];
        for(int i = 0;i<numRows;i++){
            tables[i][0] = 1;
            tables[i][i] = 1;
        }
        for(int i = 2;i<numRows;i++){
            for(int j = 1;j<i;j++){
                tables[i][j] = tables[i-1][j] + tables[i-1][j-1];
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i < numRows;i++){
            List<Integer> ans = new ArrayList<>();
            for(int j = 0;j<numRows;j++){
                if(tables[i][j]!=0)
                ans.add(tables[i][j]);
            }
            list.add(ans);
        }
        return list;
    }
}