class Solution {
    public boolean isPossible(long mid,int ranks[],int cars){
        long total = 0;
        for(int rank : ranks){
            total += (int)Math.sqrt(mid/rank);
        }
        if(total < cars)return false;
        return true;
    }
    public long repairCars(int[] ranks, int cars) {
        int max = Integer.MIN_VALUE;
        for(int rank : ranks){
            if(rank > max)max = rank;
        }
        long left = 1;
        long right = (long)(max * Math.pow(cars,2));
        long answer = 0;
        while(left <= right){
            long mid = left + (right - left)/2;
            if(isPossible(mid,ranks,cars)){
                right = mid - 1;
                answer = mid;
            }
            else
            left = mid + 1;
        }
        return answer;
    }
}