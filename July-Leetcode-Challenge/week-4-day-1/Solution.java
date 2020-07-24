/*

Title: Binary Tree Zigzag Level Order Traversal

Problem Statement: Given a binary tree, return the zigzag level order traversal 
of its nodes' values. (ie, from left to right, then right to left for 
the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = false;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> cur = new ArrayList<>(size);
            for(int i = 0; i < size; i++) cur.add(0);
            
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(flag == true){
                    cur.set(size - 1 - i, temp.val);
                }else{
                    cur.set(i, temp.val);
                }
                
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
            }
            
            res.add(cur);
            flag = !flag;
        }
        
        return res;
    }
}