class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        int firstDiff = 0;
        int secondDiff = 0;
        int numDiffs = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                numDiffs++;

                if (numDiffs > 2)
                    return false;
                else if (numDiffs == 1) {
                    firstDiff = i;
                } else {
                    secondDiff = i;
                }
            }
        }

        return (s1.charAt(firstDiff) == s2.charAt(secondDiff) &&
                s1.charAt(secondDiff) == s2.charAt(firstDiff));
    }
}