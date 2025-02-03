class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight  = 0;
        int currentMax = 0;
        int n = weights.length;
        for(int w:weights){
            totalWeight += w;
            if(currentMax < w){
                currentMax = w;
            }
        }
        int left = currentMax;
        int right = totalWeight;

        while(left<right){
            int mid = left + (right-left)/2;
            int currentWeight = 0;
            int currentDays = 1;
            for(int w:weights){
                if(w+currentWeight>mid){
                    currentWeight = 0;
                    currentDays++;
                }
                currentWeight += w;
            }
            if(currentDays > days){
                left = mid + 1;
            }
            else
            right = mid;
        }
        return left;
    }
}