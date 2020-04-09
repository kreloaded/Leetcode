/*
Given a matrix of m x n elements (m rows, n columns), 
return all elements of the matrix in spiral order.

Example 1 :

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2 :

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

https://leetcode.com/problems/spiral-matrix/
*/

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	//list for storing and returning the resultset
        List<Integer> list = new ArrayList<>();
        
        int m = matrix.length;
        //if matrix is null
        if(m==0)
        {
            return list;
        }
        
        int n = matrix[0].length;
        
        int T=0;	//for top row
        int B=m-1;	//for bottom row
        int L=0;	//for first column
        int R=n-1;	//for last column
        
        int dir = 0;	//dir variable for checking and changing direction accordingly
        //dir == 0 : left to right
        //dir == 1 : top to bottom
        //dir == 2 : right to left
        //dir == 3 : bottom to top
        
        while(T<=B && L<=R)
        {
			if(dir==0)
			{
				//left to right
				for(int i=L;i<=R;i++)
				{
				  list.add(matrix[T][i]);
				}
				T++;
			}
            
			else if(dir==1)
			{
				//top to bottom
			    for(int i=T;i<=B;i++)
			    {
			        list.add(matrix[i][R]);
			    }
			    R--;
			}
            
            else if(dir==2)
            {
            	//right to left
                for(int i=R;i>=L;i--)
                {
                    list.add(matrix[B][i]);
                }
                B--;
            }
            
            else if(dir==3)
            {
            	//bottom to top
                for(int i=B;i>=T;i--)
                {
                    list.add(matrix[i][L]);
                }
                L++;
            }
            
            dir = (dir+1)%4;
        }
        
        return list;
    }
}


class SpiralMatrix
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

		Solution s = new Solution();
		List<Integer> list = new ArrayList<>();
		list = s.spiralOrder(matrix);

		System.out.println(list);
	}
}