/*

Title : Valid Parenthesis String

Given a string containing only three types of characters: '(', ')' and '*', 
write a function to check whether this string is valid. We define the validity of a string by these rules:

1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
5. An empty string is also valid.

Example 1:

Input: "()"
Output: True

Example 2:

Input: "(*)"
Output: True

Example 3:

Input: "(*))"
Output: True

Note:The string size will be in the range [1, 100].

*/

class Solution {
    public boolean checkValidString(String s) {
    	// two stacks to track parantheses
        Stack<Integer> paranthesis = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
        	// push respective index for paranthesis and star in respective stacks
            if(s.charAt(i) == '(') {
                paranthesis.push(i);
            }
            else if(s.charAt(i) == '*') {
                star.push(i);
            }
            else{
            	// both stacks empty and found ")" next - should return false
                if(paranthesis.isEmpty() && star.isEmpty()) {
                    return false;
                }
                if(!paranthesis.isEmpty()) {
                    paranthesis.pop();
                }
                else star.pop();
            }
        }
        
        while(!paranthesis.isEmpty() && !star.isEmpty()) {
        	// "(" after "*" is must return false
            if(paranthesis.peek() > star.peek()) {
                return false;
            }
            paranthesis.pop();
            star.pop();
        }
        return paranthesis.isEmpty();
    }
}