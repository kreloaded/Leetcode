/*

Title: Path Sum III

Problem Statement: You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go 
downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

*/

// Java Solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        
        helper(root, 0, sum, map);
        
        return count;
    }

    private void helper(TreeNode root, int currSum, int target, Map<Integer, Integer> map) {
        if (root == null) return;
        
		currSum += root.val;
        
		if (map.containsKey(currSum - target)) {
            count += map.get(currSum - target);
        }
        
		map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        helper(root.left, currSum, target, map);
        helper(root.right, currSum, target, map);
        
        map.put(currSum, map.get(currSum) - 1);
    }
}