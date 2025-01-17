class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        if (n == 1) {
            if (derived[0] == 0)
                return true;
            return false;
        }
        int original[] = new int[n];
        if (derived[0] == 0) {
            original[0] = 0;
            original[1] = 0;
        } else {
            original[0] = 0;
            original[1] = 1;
        }
        for (int i = 1; i < n - 1; i++) {
            if (derived[i] == 1) {
                if (original[i] == 0) {
                    original[i + 1] = 1;
                } else
                    original[i + 1] = 0;
            }
            if (derived[i] == 0) {
                if (original[i] == 0) {
                    original[i + 1] = 0;
                } else
                    original[i + 1] = 1;
            }
        }
        int check = original[n - 1] ^ original[0];
        if (check == derived[n - 1])
            return true;
        return false;
    }
}