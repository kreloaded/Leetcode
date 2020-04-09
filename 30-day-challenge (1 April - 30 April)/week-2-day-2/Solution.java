/* 
Backspace String Compare

Given two strings S and T, return if they are equal when both are typed 
into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
*/

// solution with O(N) time and O(N) space.

class Solution {
    public boolean backspaceCompare(String S, String T) {
        S = getStringWithoutHash(S);
        T = getStringWithoutHash(T);
        return S.equals(T);
    }
    
    public String getStringWithoutHash(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder(); 
        
        for(int i=0; i<str.length(); i++) {
            char strChar = str.charAt(i);
            if(strChar != '#') {
                stack.push(strChar);
            }
            else if(strChar == '#' && !stack.isEmpty()) {
                stack.pop();
            }
        }
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}

