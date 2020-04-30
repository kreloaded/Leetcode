/*

Title: Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

*/

// Java Solution

class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArraySum(nums, 0, nums.length-1); 
    }

    int maxSubArraySum(int nums[], int l, int h) { 
        if (l == h) 
            return nums[l]; 

        int m = (l + h)/2; 

        return Math.max(Math.max(maxSubArraySum(nums, l, m), 
                            maxSubArraySum(nums, m+1, h)), 
                            maxCrossingSum(nums, l, m, h)); 
    }
    
    int maxCrossingSum(int nums[], int l, int m, int h) { 
        int sum = 0; 
        int left_sum = Integer.MIN_VALUE; 
        for (int i = m; i >= l; i--) 
        { 
            sum = sum + nums[i]; 
            if (sum > left_sum) 
            left_sum = sum; 
        } 
  
        sum = 0; 
        int right_sum = Integer.MIN_VALUE; 
        for (int i = m + 1; i <= h; i++) 
        { 
            sum = sum + nums[i]; 
            if (sum > right_sum) 
            right_sum = sum; 
        } 
  
        return left_sum + right_sum; 
    } 
}