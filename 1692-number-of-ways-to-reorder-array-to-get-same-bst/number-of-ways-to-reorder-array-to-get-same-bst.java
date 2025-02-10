class Solution {
    int[][] tables;

    public int solve(List<Integer> nums) {
        int m = nums.size();
        if (m < 3) {
            return 1;
        }
        ArrayList<Integer> leftArray = new ArrayList<>();
        ArrayList<Integer> rightArray = new ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(0)) leftArray.add(nums.get(i));
            else rightArray.add(nums.get(i));
        }
        int left = solve(leftArray) % 1000000007;
        int right = solve(rightArray) % 1000000007;

        long result = (long) tables[nums.size() - 1][leftArray.size()] * left % 1000000007;
        result = result * right % 1000000007;

        return (int) result;
    }

    public int numOfWays(int[] nums) {
        int n = nums.length;
        tables = new int[n][n];
        for (int i = 0; i < n; i++) {
            tables[i][0] = 1;
            tables[i][i] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                tables[i][j] = (tables[i - 1][j] + tables[i - 1][j - 1]) % 1000000007;
            }
        }
        List<Integer> arrList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int answer = solve(arrList);
        return (answer - 1) % 1000000007;
    }
}