/*

Problem Statement: 1252. Cells with Odd Values in a Matrix

Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.

Return the number of cells with odd values in the matrix after applying the increment to all indices.


Example 1:


Input: n = 2, m = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.



Example 2:


Input: n = 2, m = 2, indices = [[1,1],[0,0]]
Output: 0
Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.
 

Constraints:

1 <= n <= 50
1 <= m <= 50
1 <= indices.length <= 100
0 <= indices[i][0] < n
0 <= indices[i][1] < m

*/

// Java Solution

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        int count = 0;
        for(int i=0; i<indices.length; i++) {
            // update row
            rowUpdate(matrix, indices[i][0]);
            // update column
            columnUpdate(matrix, indices[i][1]);
        }
        
        // count odd numbers
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]%2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private void rowUpdate(int matrix[][], int row) {
        for(int i=0; i<=matrix[0].length-1; i++) {
            matrix[row][i]++;
        }
    }
    
    private void columnUpdate(int matrix[][], int column) {
        for(int i=0; i<=matrix.length-1; i++) {
            matrix[i][column]++;
        }
    }
}