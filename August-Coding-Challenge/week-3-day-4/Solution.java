/*

Title: Numbers With Same Consecutive Differences

Problem Statement: Return all non-negative integers of length N such that the 
absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. 
For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.

Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]

Explanation: Note that 070 is not a valid number, because it has leading zeroes.


Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 

Note:

1 <= N <= 9
0 <= K <= 9

*/

// Java Solution

class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
        List<Integer> queue = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for(int i = 2; i <= N; i++) {
            List<Integer> newQueue = new ArrayList<>();
            for (int num : queue) {
                int lastDigit = num % 10, nextNum = num * 10;

                int d1 = lastDigit + K; // next higher digit
                if (d1 < 10) newQueue.add(nextNum + d1);
                
                int d2 = lastDigit - K; // next lower digit
                if (K != 0 && d2 >= 0) newQueue.add(nextNum + d2);
            }
            queue = newQueue;
        }

        int result[] = new int[queue.size()], j=0;
        for(int n: queue) result[j++] = n;
        return result;
    }
}