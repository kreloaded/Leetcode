import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lesser = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        int count = 0;
        for (int num : nums) {
            if (num < pivot) {
                lesser.add(num);
            } else if (num > pivot) {
                greater.add(num);
            } else {
                count++;
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < lesser.size(); i++) {
            result[i] = lesser.get(i);
        }

        int j = lesser.size();
        while (count-- > 0 && j < nums.length) {
            result[j] = pivot;
            j++;
        }

        for (int i = 0; i < greater.size(); i++) {
            result[j++] = greater.get(i);
        }

        return result;
    }
}