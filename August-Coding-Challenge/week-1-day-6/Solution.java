/*

Title: Find All Duplicates in an Array

Problem Statement: Given an array of integers, 
	1 ≤ a[i] ≤ n (n = size of array), 
	some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

*/

// Java Solution

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - 1) % n;
            nums[index] += n;
        }
        
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 2 * n) {
                resultList.add(i + 1);
            }
        }
        return resultList;
    }
}
