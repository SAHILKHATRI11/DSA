class ProductOfNumbers {
    ArrayList<Integer> list;
    int size ;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
        size = 0;
    }
    
    public void add(int num) {
        if(num == 0){
            this.list = new ArrayList<Integer>();
            this.list.add(1);
            this.size = 0;
            }
            else{
                this.list.add(this.list.get(size)*num);
                this.size++;
            }
        }

    public int getProduct(int k) {
        if(this.size < k)return 0;
        int a = list.get(list.size()-1);
        int b = list.get(list.size()-k-1);
        return a/b;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */