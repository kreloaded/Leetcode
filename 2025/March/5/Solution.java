class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int N = n * n;

        long expectedSum = (long) N * (N + 1) / 2;
        long expectedSqSum = (long) N * (N + 1) * (2 * N + 1) / 6;

        long actualSum = 0, actualSqSum = 0;
        int[] count = new int[N + 1];

        int repeated = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                actualSum += num;
                actualSqSum += (long) num * num;

                if (++count[num] > 1) {
                    repeated = num;
                }
            }
        }

        long xMinusY = expectedSum - actualSum;
        long xPlusY = (expectedSqSum - actualSqSum) / xMinusY;
        int missing = (int) ((xMinusY + xPlusY) / 2);

        return new int[] { repeated, missing };
    }
}
