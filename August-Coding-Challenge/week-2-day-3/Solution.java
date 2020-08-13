/*

Title:Excel Sheet Column Number

Problem Statement: Given a column title as appear in an Excel sheet, 
	return its corresponding column number.


For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...


Example 1:

Input: "A"
Output: 1


Example 2:

Input: "AB"
Output: 28


Example 3:

Input: "ZY"
Output: 701
 

Constraints:

1 <= s.length <= 7
s consists only of uppercase English letters.
s is between "A" and "FXSHRXW".

*/

// Java Solution

class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        int position = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int val = s.charAt(i) - 'A' + 1;
            int power = (int)Math.pow(26, position);
            
            result += (val * power);
            position++;
        }
        
        return result;
    }
}