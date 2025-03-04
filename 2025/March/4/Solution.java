class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }

            n = n / 3;
        }

        return true;
    }
}

// TC: O(log3(n))
// SC: O(1)