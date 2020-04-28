/*

Title: Maximal Square

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

*/

// Java Solution

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int maxSquare = 0;
        if (matrix.length < matrix[0].length) {
            int[] previous = new int[matrix.length];
            int[] current = new int[matrix.length];
            for (int j = 0; j < matrix[0].length; j++) {
                for (int i = 0; i < matrix.length; i++) {
                    if (matrix[i][j] == '0') {
                        current[i] = 0;
                    } else {
                        current[i] = 1;
                        if (i != 0 && j != 0) {
                            current[i] += Math.min(previous[i - 1], Math.min(previous[i], current[i - 1]));
                        }
                        maxSquare = Math.max(maxSquare, current[i]);
                    }
                }
                int[] temp = current;
                current = previous;
                previous = temp;
            }
        } else {
            int[] previous = new int[matrix[0].length];
            int[] current = new int[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '0') {
                        current[j] = 0;
                    } else {
                        current[j] = 1;
                        if (i != 0 && j != 0) {
                            current[j] += Math.min(previous[j - 1], Math.min(previous[j], current[j - 1]));
                        }
                        maxSquare = Math.max(maxSquare, current[j]);
                    }
                }
                int[] temp = current;
                current = previous;
                previous = temp;
            }
        }
        return maxSquare * maxSquare;
    
    }
}