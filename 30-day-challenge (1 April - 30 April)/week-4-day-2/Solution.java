/*
Title: Bitwise AND of Numbers Range

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0

*/

// Java Solution : bit manipulation 

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        // shifting of bits will help here
        // count no. of shifts performed
        int count = 0;
        while(m != n) {
            m = m>>1;
            n = n>>1;
            count++;
        }
        
        m = m << count;
        return m;
    }
}
