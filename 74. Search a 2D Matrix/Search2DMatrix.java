/*
74. Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1 : 

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2 :

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false


https://leetcode.com/problems/search-a-2d-matrix/

*/

import java.util.*;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0)
        {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        //treating 2d matrix as a single 1d matrix
        int left = 0;
        int right = rows*columns-1;
        
        while(left<=right)
        {
            int midpoint = left + (right-left)/2; //midpoint calculation according to the 2D matrix
            
            int midpoint_element = matrix[midpoint/columns][midpoint%columns]; //finding midpoint element
            
            //binary search same as searching in a single array
            if(midpoint_element == target) {
                return true;
            }
            
            else if(target < midpoint_element ) {
                right = midpoint-1;
            }
            
            else if(target > midpoint_element) {
                left = midpoint+1;
            }
        }
        return false;
    }
}

class Search2DMatrix
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