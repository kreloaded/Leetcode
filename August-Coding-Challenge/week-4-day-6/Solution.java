/*

Title: Find Right Interval

Problem Statement: Given a set of intervals, for each of the interval i, 
check if there exists an interval j whose start point is bigger than or equal 
to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, 
which means that the interval j has the minimum start point to build the "right" 
relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. 
Finally, you need output the stored value of each interval as an array.


Note:

You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
 

Example 1:

Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.

 

Example 2:

Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
 


Example 3:

Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

*/

// Java Solution

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int N = intervals.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[intervals.length];
        
        int[] temp = new int[N];
        for(int i = 0; i < N; i++){
            temp[i] = intervals[i][0];
            map.put(temp[i], i);
        }
        
        Arrays.sort(temp);
        
        for(int i = 0; i < N; i++){
            int index = binarySearch(temp, intervals[i][1]);
            result[i] = index == -1 ? -1 : map.get(temp[index]);
        }
        
        return result;
    }
    
    public int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
            
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return ans;
    }
}
