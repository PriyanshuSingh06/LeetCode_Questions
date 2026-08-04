class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] ans = new String[words.length];

        for (String word : words) {
            int index = word.charAt(word.length() - 1) - '1';
            ans[index] = word.substring(0, word.length() - 1);
        }

        return String.join(" ", ans);
    }
}