class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num[] : nums2){
            int id = num[0];
            int val = num[1];
            map.put(id,val);
        }

        for(int num[] : nums1){
            int id = num[0];
            int val = num[1];
            map.put(id,map.getOrDefault(id,0)+ val);
        }
        
        int answer[][] = new int[map.size()][2];
        int counter = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            answer[counter][0] = entry.getKey();
            answer[counter][1] = entry.getValue();
            counter++;
        }
        return answer;
    }
}