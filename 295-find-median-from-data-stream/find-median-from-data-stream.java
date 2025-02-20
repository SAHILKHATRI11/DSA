class MedianFinder {
    PriorityQueue<Integer> min = new PriorityQueue<>((a,b)->(a-b));
    PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->(b-a));
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(min.size() == 0 && max.size() == 0){
            min.offer(num);
            return;
        }
        if(min.size()-max.size()==1){
            if(num > min.peek()){
                int removeFromMin = min.poll();
                max.offer(removeFromMin);
                min.offer(num);
            }
            else{
            max.offer(num);
            }
            return;
        }
        if(max.size()-min.size()==1){
            if(num < max.peek()){
                int removeFromMax = max.poll();
                min.offer(removeFromMax);
                max.offer(num);
            }
            else{
                min.offer(num);
            }
            return;
        }
        else if(min.size() == max.size()){
            if(min.peek() < num){
                min.offer(num);
            }
            else{
                max.offer(num);
            }
            return;
        }
    }
    
    public double findMedian() {
        if(min.size() == max.size()){
            int num1 = min.peek();
            int num2 = max.peek();
            double median = (num1 + num2)*1.0/2;
            return median;
        }
        if(min.size()>max.size()){
            return min.peek();
        }
        else{
            return max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */