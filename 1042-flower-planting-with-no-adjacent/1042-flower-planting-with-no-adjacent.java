class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] path : paths) {
            int u = path[0] - 1;
            int v = path[1] - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] ans = new int[n];

        // Assign flowers greedily
        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5]; // flowers 1 to 4

            // Mark flowers used by neighbors
            for (int neighbor : graph[i]) {
                used[ans[neighbor]] = true;
            }

            // Choose the first available flower
            for (int flower = 1; flower <= 4; flower++) {
                if (!used[flower]) {
                    ans[i] = flower;
                    break;
                }
            }
        }

        return ans;
    }
}