 import java.util.*;

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s.length() == 0 || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return result;
        }

        // Frequency of words we need
        Map<String, Integer> need = new HashMap<>();

        for (String word : words) {
            need.put(word, need.getOrDefault(word, 0) + 1);
        }

        // Try each possible starting offset
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int right = offset;

            Map<String, Integer> window = new HashMap<>();

            int count = 0;

            while (right + wordLen <= s.length()) {

                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // Word is not required
                if (!need.containsKey(word)) {

                    window.clear();
                    count = 0;
                    left = right;

                } else {

                    window.put(
                        word,
                        window.getOrDefault(word, 0) + 1
                    );

                    count++;

                    // Too many copies of this word
                    while (window.get(word) > need.get(word)) {

                        String leftWord =
                            s.substring(left, left + wordLen);

                        window.put(
                            leftWord,
                            window.get(leftWord) - 1
                        );

                        left += wordLen;
                        count--;
                    }

                    // All words are present
                    if (count == wordCount) {

                        result.add(left);

                        // Move window forward
                        String leftWord =
                            s.substring(left, left + wordLen);

                        window.put(
                            leftWord,
                            window.get(leftWord) - 1
                        );

                        left += wordLen;
                        count--;
                    }
                }
            }
        }

        return result;
    }
}