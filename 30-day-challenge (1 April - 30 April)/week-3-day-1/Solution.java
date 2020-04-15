/*
Product of Array Except Self

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/

// Solution 1 - using two arrays : left and right

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int left[] = new int[size];
        int right[] = new int[size];
        
        int product = left[0] = nums[0];
        for(int i=1; i<size; i++) {
            product = product * nums[i];
            left[i] = product;
        }
        
        product = right[size - 1] = nums[size - 1];
        for(int i=size-2; i>0; i--) {
            product = product * nums[i];
            right[i] = product;
        }
        
        nums[0] = right[1];
        nums[size - 1] = left[size - 2];
        
        for(int i=1; i<size-1; i++) {
            nums[i] = left[i-1] * right[i+1]; 
        }
        
        return nums;
    }
}

// Solution 2 - using single array instead of two

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }
}