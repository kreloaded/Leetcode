import java.util.TreeMap;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int num1 = nums[i];
            int digitSum = 0;

            while (num > 0) {
                digitSum += (num % 10);
                num = num / 10;
            }

            PriorityQueue<Integer> q = map.getOrDefault(digitSum, new PriorityQueue<>(Collections.reverseOrder()));
            q.add(num1);
            map.put(digitSum, q);
        }

        int max = 0;
        for (PriorityQueue<Integer> q : map.values()) {
            System.out.println(q);
            if (q.size() > 1) {
                int first = q.poll();
                int second = q.poll();

                max = Math.max(max, first + second);
            }
        }

        return max == 0 ? -1 : max;
    }
}

// TC: O(n log n)
// SC: O(n)