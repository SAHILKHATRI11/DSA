class Solution {
    public boolean solve(int arr[], int n, Set<Integer> set, int index) {
        while (index < arr.length && arr[index] != -1) {
            index++;
        }
        if (index == arr.length)
            return true;
        for (int i = n; i >= 1; i--) {
            if (set.contains(i))
                continue;
            arr[index] = i;
            set.add(i);
            if (i == 1) {
                if (solve(arr, n, set, index + 1) == true)
                    return true;
            } else if (index + i < arr.length && arr[index + i] == -1) {
                arr[index + i] = i;
                if (solve(arr, n, set, index + 1) == true)
                    return true;
                arr[index + i] = -1;
            }
            arr[index] = -1;
            set.remove(i);
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        Set<Integer> used = new HashSet<>();
        int arr[] = new int[2 * n - 1];
        Arrays.fill(arr, -1);
        if (solve(arr, n, used, 0))
            return arr;
        return arr;
    }
}