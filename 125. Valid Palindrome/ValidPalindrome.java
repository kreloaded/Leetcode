/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false

https://leetcode.com/problems/valid-palindrome/
*/

import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        if(s==null) {
            return true;
        }

        //replacing all the other characters except alphanumeric
        s = s.replaceAll("\\s","");
        s = s.replaceAll("[^a-zA-Z0-9]","");
        s = s.toLowerCase();
        
        //System.out.println("String is :"+s);
        return checkPalindrome(s);
    }
    
    //check whether the string is palindrome or not
    public boolean checkPalindrome(String s)
    {
        int i=0;
        int j=s.length()-1;
        
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

class ValidPalindrome
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		Solution s = new Solution();
		System.out.println(s.isPalindrome(str));

	}
}