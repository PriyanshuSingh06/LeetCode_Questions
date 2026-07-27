
class Solution {
    public String convert(String s, int numRows) {
        // Base cases: if only 1 row or string is shorter than rows, no change is needed
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        int n = s.length();
        char[] result = new char[n];
        int cycleStep = 2 * numRows - 2;
        int count = 0;

        // Process row by row
        for (int i = 0; i < numRows; i++) {
            // Traverse the string in jumps of cycleStep
            for (int j = 0; j + i < n; j += cycleStep) {
                // 1. Add the main vertical column character
                result[count++] = s.charAt(j + i);
                
                // 2. Add the inner diagonal character if we are in a middle row
                if (i != 0 && i != numRows - 1) {
                    int diagonalIndex = j + cycleStep - i;
                    if (diagonalIndex < n) {
                        result[count++] = s.charAt(diagonalIndex);
                    }
                }
            }
        }

        return new String(result);
    }
}