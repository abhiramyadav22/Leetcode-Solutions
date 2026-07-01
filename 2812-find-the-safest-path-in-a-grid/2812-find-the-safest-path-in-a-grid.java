class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = getDist(grid, n);
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> b[0] - a[0]);
        boolean[][] vis = new boolean[n][n];
        pq.offer(new int[]{dist[0][0], 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int safe = cur[0];
            int r = cur[1];
            int c = cur[2];
            if (vis[r][c])
                continue;

            vis[r][c] = true;

            if (r == n - 1 && c == n - 1)
                return safe;

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (isValid(nr, nc, n) && !vis[nr][nc]) {

                    int ns = Math.min(safe, dist[nr][nc]);

                    pq.offer(new int[]{ns, nr, nc});
                }
            }
        }

        return 0;
    }

    private int[][] getDist(List<List<Integer>> grid, int n) {

        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid.get(r).get(c) == 1) {

                    dist[r][c] = 0;
                    q.offer(new int[]{r, c});
                }
            }
        }

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (isValid(nr, nc, n) && dist[nr][nc] == -1) {

                    dist[nr][nc] = dist[r][c] + 1;

                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return dist;
    }

    private boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}