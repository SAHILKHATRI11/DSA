class NumArray {
    int segTree[];
    int n;
    public void buildTree(int i,int left,int right,int[] nums){
        if(left == right){
            segTree[i] = nums[left];
            return;
        }
        int mid = left + (right - left)/2;
        buildTree(2 * i + 1,left,mid,nums);
        buildTree(2 * i + 2,mid + 1,right,nums);
        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
        return;
    }
    public void updateQuery(int i,int index,int val,int left,int right){
        if(left == right){
            segTree[i] = val;
            return;
        }
        int mid = left + (right - left)/2;
        if(mid < index){
         updateQuery(2 * i + 2,index,val,mid + 1,right);
        }
        else{
         updateQuery(2 * i + 1,index,val,left,mid);
        }
        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
        return;
    }
    public int querySum(int i,int start,int end,int left,int right){
        if(end  < left || start > right)return 0;
        if(start >= left && end <= right)return segTree[i];
        int mid = start + (end - start)/2;
        return querySum(2 * i + 1,start,mid,left,right) + querySum(2 * i + 2,mid + 1,end,left,right);
    }
    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4 * n];
        buildTree(0,0,n-1,nums);
    }
    
    public void update(int index, int val) {
        updateQuery(0,index,val,0,n-1);
    }
    
    public int sumRange(int left, int right) {
       return querySum(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */