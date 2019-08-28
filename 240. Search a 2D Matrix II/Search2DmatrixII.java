/*
240. Search a 2D Matrix II :

Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.

https://leetcode.com/problems/search-a-2d-matrix-ii/

*/
import java.util.*;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
        {
            return false;
        }
        
        int row = 0;
        int column = matrix[0].length-1;
        
        while(row<matrix.length && column >= 0)
        {
            if(matrix[row][column]==target) {
                return true;
            }
            else if(matrix[row][column] > target) {
                --column;
            }
            else {
                ++row;
            }
        }
        return false;
    }
}

class Search2DMatrixII
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		int matrix[][] = new int[m][n];

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				matrix[i][j] = sc.nextInt();
			}
		}

		int target = sc.nextInt();
		Solution s = new Solution();
		boolean result = s.searchMatrix(matrix,target);
		System.out.println(result);
	}
}