/*

Title: Find All Anagrams in a String

problem Statement: Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.


Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".


Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

// Java Solution

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        for (int i=0; i<=s.length()-p.length(); i++) {
            if (areAnagram(s.substring(i, i+p.length()),p)) {
                result.add(i);
            }
        }
        return result;
    }
    
    public boolean areAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        
        int NO_OF_CHARS = 256;
        
        int count1[] = new int[NO_OF_CHARS];
        int count2[] = new int[NO_OF_CHARS];
        
        for (int i=0; i<a.length() && i<b.length(); i++) {
            count1[a.charAt(i)]++;
            count2[b.charAt(i)]++;
        }
        
        for (int i=0; i<NO_OF_CHARS; i++) {
            if (count1[i] != count2[i]) return false;
        }
        
        return true;
    }
}