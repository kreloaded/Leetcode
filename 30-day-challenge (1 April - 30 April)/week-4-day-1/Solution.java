/*
Title: Subarray Sum Equals K

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2

Note: The length of the array is in range [1, 20,000].
	
	The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 	
 	Hide Hint #1  
		- Will Brute force work here? Try to optimize it.

   	Hide Hint #2  
		- Can we optimize it by using some extra space?

   	Hide Hint #3  
		- What about storing sum frequencies in a hash table? Will it be useful?

   	Hide Hint #4  
		- sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1. Can we use this property to optimize it.

*/

// Java Solution

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer, Integer> map = new HashMap<>();  
        
        int result = 0;   
        int sum = 0;  
        
        for (int i = 0; i < nums.length; i++) {   
            sum += nums[i];  
            if (sum == k)   
                result++;   
            
            if (map.containsKey(sum - k))   
                result += map.get(sum - k);  
                 
            Integer count = map.get(sum); 
            if (count == null) 
                map.put(sum, 1); 
            else
                map.put(sum, count+1);  
        }  
        
        return result;
    }
}