class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];

        int runningSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                runningSum = nums[i];
            } else {
                runningSum += nums[i];
            }

            maxSum = Math.max(maxSum, runningSum);
        }

        return maxSum;
    }
}