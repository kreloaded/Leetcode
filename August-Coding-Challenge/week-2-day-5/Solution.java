/*

Title: Pascal's Triangle II

Problem Statement: Given a non-negative index k where k ≤ 33, 
return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?

*/

// Java Solution

class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
		result[0] = 1;
        for (int i = 1; i < result.length; i++)
            result[i] = (int) ((long) result[i - 1] * (rowIndex - (i - 1)) / (i));

        return Arrays.asList(result);
    }
}
