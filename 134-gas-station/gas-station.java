class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumMax = 0;
        int n = gas.length;
        int pivot = -1;
        int totalGas = 0;
        int ans = 0;
        int diff = 0;
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < n; i++) {
             totalGas += gas[i] - cost[i];
             sumGas += gas[i];
             sumCost += cost[i];
             if(totalGas < 0){
                ans = i + 1;
                totalGas = 0;
             }
        }
        return sumGas>=sumCost? ans:-1;
    }
}