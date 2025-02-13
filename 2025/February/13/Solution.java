import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int ops = 0;
        for (int num : nums) {
            if (num <= k)
                pq.add((long) num);
        }

        while (pq.size() >= 2) {
            long first = pq.poll();
            if (first >= k)
                return ops;

            long second = pq.poll();
            long updated = first * 2 + second;
            pq.add(updated);
            ops++;
        }

        return ops;
    }
}

// TC: O(n)
// SC: O(n)