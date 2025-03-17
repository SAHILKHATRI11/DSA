class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        if(n % 2 != 0)return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        } 
        for(int num : map.keySet()){
            int get = map.get(num);
            if(get % 2 != 0)return false;
        }
        return true;
    }
}