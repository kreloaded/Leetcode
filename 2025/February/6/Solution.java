import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i] * nums[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }

        int count = 0;
        for (int value : map.values()) {
            if (value > 1) {
                count += 8 * nc2(value);
            }
        }

        return count;
    }

    private int nc2(int n) {
        return (n * (n - 1)) / 2;
    }
}

// TC: O(n^2)
// SC: O(n^2)