/*

Title: Cousins in Binary Tree

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.


Example 1:

Input: root = [1,2,3,4], x = 4, y = 3
Output: false


Example 2:

Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true


Example 3:

Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.

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
    public boolean isCousins(TreeNode root, int x, int y) {
        NodeInfo nodeInfo = new NodeInfo(0, null);
        return isCousinsUtil(root, null, x, y, 0, nodeInfo);
    }
    
    private boolean isCousinsUtil(TreeNode root, TreeNode parent, int x, int y, int level, NodeInfo nodeInfo) {
        if(root == null)
            return false;
        
        if(root.val == x || root.val == y){
            if(nodeInfo.parent == null){
                nodeInfo.parent = parent;
                nodeInfo.level = level;
            }
            else if(nodeInfo.parent != parent && nodeInfo.level == level){
                return true;
            }
        }
        return isCousinsUtil(root.left, root, x, y, level + 1, nodeInfo) || isCousinsUtil(root.right, root, x, y, level + 1, nodeInfo);
    }
    
    class NodeInfo{
        int level = 0;
        TreeNode parent = null;
        
        public NodeInfo(int level, TreeNode parent){
            this.level = level;
            this.parent = parent;
        }
    }
}