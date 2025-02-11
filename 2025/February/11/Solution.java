import java.util.Stack;

class Solution {
    public String removeOccurrences(String s, String part) {
        int m = s.length();
        int n = part.length();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < m; i++) { // O(m * n)
            st.push(s.charAt(i));

            if (st.size() >= n && checkMatch(st, part, n) == true) {
                for (int j = 0; j < n; j++) {
                    st.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.reverse().toString();
    }

    private boolean checkMatch(Stack<Character> st, String part, int n) {
        Stack<Character> tempSt = new Stack<>();
        tempSt.addAll(st);

        for (int i = n - 1; i >= 0; i--) { // O(n)
            if (tempSt.peek() != part.charAt(i)) {
                return false;
            }

            tempSt.pop();
        }

        return true;
    }
}