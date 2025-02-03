class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1, dec = 1, maxLen = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                inc++;
                dec = 1; // reset
            } else if (nums[i + 1] < nums[i]) {
                dec++;
                inc = 1; // reset
            } else {
                dec = 1;
                inc = 1;
            }

            maxLen = Math.max(maxLen, Math.max(inc, dec));
        }

        return maxLen;
    }
}

// TC: O(n)
// SC: O(1)