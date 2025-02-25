class Solution {
    public int numOfSubarrays(int[] arr) {
        int oddCount = 0 ;
        int evenCount = 0;
        int prev = 0;
        int answer = 0;
        for(int i = 0 ;i<arr.length;i++){
            arr[i] = prev + arr[i];
            prev = arr[i];
        }
        for(int i = 0;i < arr.length;i++){
            if(arr[i]%2!=0){
                oddCount++;
                answer = (answer + evenCount + 1)%1000000007;
            }
            else{
                evenCount++;
                answer = (answer + oddCount)%1000000007;
            }
        }
        return answer % 1000000007;
    }
}