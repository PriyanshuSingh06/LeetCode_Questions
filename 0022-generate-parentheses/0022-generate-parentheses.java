 import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(result, "", 0, 0, n);

        return result;
    }

    private void backtrack(
            List<String> result,
            String current,
            int open,
            int close,
            int n) {

        // If we have used all parentheses
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // We can add '(' if open < n
        if (open < n) {
            backtrack(
                result,
                current + "(",
                open + 1,
                close,
                n
            );
        }

        // We can add ')' only if close < open
        if (close < open) {
            backtrack(
                result,
                current + ")",
                open,
                close + 1,
                n
            );
        }
    }
}