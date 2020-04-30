/*

Title: Group Anagrams

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

*/

// Java Solution

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) { 
        HashMap<HashMap<Character, Integer>, 
                ArrayList<String> > 
            resultMap = new HashMap<HashMap<Character, Integer>, 
                              ArrayList<String> >(); 
        for (String str : strs) { 
            HashMap<Character, Integer> 
                tempMap = new HashMap<Character, Integer>(); 
            
            for (int i = 0; i < str.length(); i++) { 
                if (tempMap.containsKey(str.charAt(i))) { 
                    int x = tempMap.get(str.charAt(i)); 
                    tempMap.put(str.charAt(i), ++x); 
                } 
                else { 
                    tempMap.put(str.charAt(i), 1); 
                } 
            } 
  
            if (resultMap.containsKey(tempMap)) 
                resultMap.get(tempMap).add(str); 
            else { 
                ArrayList<String> 
                    tempList = new ArrayList<String>(); 
                tempList.add(str); 
                resultMap.put(tempMap, tempList); 
            } 
        } 
        
        List<List<String> > 
            result = new ArrayList<>(); 
        for (HashMap<Character, Integer> 
                 temp : resultMap.keySet()) 
            result.add(resultMap.get(temp)); 
        return result;
  
    }
}