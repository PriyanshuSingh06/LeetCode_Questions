class Solution {
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int ans = 0;
        int totalMasks = 1 << n;

        for (int mask = 1; mask < totalMasks; mask++) {

            // Check even sum
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0)
                    sum += nums[i];
            }

            if ((sum & 1) == 1)
                continue;

            // Find one node in subset
            int start = -1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    start = i;
                    break;
                }
            }

            // BFS to check connectivity
            boolean[] vis = new boolean[n];
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            vis[start] = true;

            int visited = 0;

            while (!q.isEmpty()) {
                int cur = q.poll();
                visited++;

                for (int nxt : graph[cur]) {
                    if (!vis[nxt] && (mask & (1 << nxt)) != 0) {
                        vis[nxt] = true;
                        q.offer(nxt);
                    }
                }
            }

            if (visited == Integer.bitCount(mask))
                ans++;
        }

        return ans;
    }
}