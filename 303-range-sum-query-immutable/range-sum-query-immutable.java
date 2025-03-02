class NumArray {
    int segTree[];
    int n;
  public void buildTree(int left, int right, int i, int[] nums) {
    if (left == right) {
        segTree[i] = nums[left];
        return;
    }
    int mid = left + (right - left) / 2; 
    buildTree(left, mid, 2 * i + 1, nums);
    buildTree(mid + 1, right, 2 * i + 2, nums);
    segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
}


    public int querySum(int i, int left, int right, int start, int end) {
        if(right < start || left > end)return 0;
        if(left >= start && right <= end){
            return segTree[i];
        }
        int mid = left + (right - left) / 2;
        return querySum(2 * i + 1, left, mid, start, end) + querySum(2 * i + 2, mid + 1, right, start, end);
    }

    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4 * n];
        buildTree(0,n - 1,0,nums);
    }

    public int sumRange(int left, int right) {
        return querySum(0,0, n-1,left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */