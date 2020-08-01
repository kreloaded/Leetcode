/*

Title: Detect Capital

problem Statement: Given a word, you need to judge whether 
	the usage of capitals in it is right or not.

We define the usage of capitals in a word to be 
right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 

Example 1:

Input: "USA"
Output: True
 

Example 2:

Input: "FlaG"
Output: False
 

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

*/

// Java Solution

// 1. Char by char solution

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        
        int firstChar = word.charAt(0);
        if (firstChar >= 65 && firstChar <= 90) {
            // Go for single as well as all checks
            int secondChar = word.charAt(1);
            if (secondChar >= 65 && secondChar <= 90 ) {
                // All char must be cap
                return allCharMustBeCap(word);
            } else {
                // All char must be small
                return allCharMustBeSmall(word);
            }
        } else {
            return allCharMustBeSmall(word);
        }
    }
    
    private boolean allCharMustBeCap(String word) {
        for (int index = 1; index < word.length(); index++) {
            if (Character.isUpperCase(word.charAt(index))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean allCharMustBeSmall(String word) {
        for (int index = 1; index < word.length(); index++) {
            if (Character.isLowerCase(word.charAt(index))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}




// 2. Improved solution with REGEX

class Solution {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }
}
