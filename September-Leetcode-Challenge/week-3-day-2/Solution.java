/*

Title: Maximum XOR of Two Numbers in an Array

Given an integer array nums, return the maximum result 
of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.

Follow up: Could you do this in O(n) runtime?

 

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.


Example 2:

Input: nums = [0]
Output: 0


Example 3:

Input: nums = [2,4]
Output: 6


Example 4:

Input: nums = [8,10,2]
Output: 10


Example 5:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 

Constraints:

1 <= nums.length <= 2 * 104
0 <= nums[i] <= 231 - 1

*/

// Java Solution

class Solution {
    
    private static class TrieNode {
        private final TrieNode[] children;

        private TrieNode() {
            children = new TrieNode[2];
        }
    }

    private TrieNode root;

    public int findMaximumXOR(int[] nums) {
        root = new TrieNode();

        TrieNode curr;

        for (int num : nums) {
            curr = root;
            for (int i = 30; i >= 0; --i) {
                int bit = getIthBit(num, i);

                if (curr.children[bit ^ 1] == null) {
                    curr.children[bit ^ 1] = new TrieNode();
                }

                curr = curr.children[bit ^ 1];
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            curr = root;

            int rst = 0;
            for (int i = 30; i >= 0; --i) {
                int bit = getIthBit(num, i);

                if (curr.children[bit] != null) {
                    curr = curr.children[bit];

                    rst += (1 << i);
                } 
                else {
                    curr = curr.children[bit ^ 1];
                }
            }

            ans = Math.max(ans, rst);
            if (ans == Integer.MAX_VALUE) break;
        }

        return ans;
    }

    private int getIthBit(int num, int i) {
        return (num & (1 << i)) == 0 ? 0 : 1;
    }
}