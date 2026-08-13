import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {

            // Cookie can satisfy this child
            if (s[cookie] >= g[child]) {
                child++;
            }

            // Move to the next cookie
            cookie++;
        }

        return child;
    }
}