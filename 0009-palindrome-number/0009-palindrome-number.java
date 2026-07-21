class Solution {
    public boolean isPalindrome(int x) {
        String original = String.valueOf(x);
        String reversed = new StringBuilder(original).reverse().toString();

        return original.equals(reversed);
    }
}