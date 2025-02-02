class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        if (n <= 1)
            return true;

        int inversions = 0; // count inversions - number of inversions should be either 1 or 0

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                inversions++;
            }
        }

        if (nums[0] < nums[n - 1]) {
            inversions++;
        }

        return inversions <= 1;
    }
}