class RangeFreqQuery {
    Map<Integer,Integer> map[];
    int n;
    public void buildTree(int arr[],int i,int start,int end){
        if(start == end){
            map[i] = new HashMap<Integer,Integer>();
            map[i].put(arr[start],1);
        }
        else{
            int mid  = start + (end - start)/2;
            buildTree(arr,2*i+1,start,mid);
            buildTree(arr,2*i+2,mid+1,end);
            map[i] = new HashMap<Integer,Integer>();
            map[i] = merge(map[2*i+1],map[2*i+2]);
        }
    }
    public Map<Integer,Integer> merge(Map<Integer,Integer> p,Map<Integer,Integer> q){
        Map<Integer,Integer> answer = new HashMap<>(p);
        for(Map.Entry<Integer,Integer> entry : q.entrySet()){
            answer.put(entry.getKey(),answer.getOrDefault(entry.getKey(),0)+entry.getValue());
        }
        return answer;
    }
    public RangeFreqQuery(int[] arr) {
        n = arr.length;
        map = new Map[4 * n];
        buildTree(arr,0,0,n-1);
    }
    public int queryCount(int left,int right,int i,int start,int end,int value){
        if(right<start || left > end)return 0;
        if(left <= start && right >= end){
            return map[i].getOrDefault(value,0);
        }
        int mid = start + (end - start)/2;
        return queryCount(left,right,2*i+1,start,mid,value) + queryCount(left,right,2*i+2,mid+1,end,value);
    }
    public int query(int left, int right, int value) {
        return queryCount(left,right,0,0,n-1,value);
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */