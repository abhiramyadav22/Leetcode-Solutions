import java.util.Arrays;

class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        if (n == 0)
            return 0;
        Arrays.sort(walls);
        long[][] vp = new long[n][2];
        for (int i = 0; i < n; i++) {
            vp[i][0] = robots[i];
            vp[i][1] = distance[i];
        }
        Arrays.sort(vp, (a, b) -> Long.compare(a[0], b[0]));
        long[][] intervals = new long[n][4];
        for (int i = 0; i < n; i++) {
            long pos = vp[i][0];
            long d = vp[i][1];
            long left_block = (i > 0 ? vp[i - 1][0] : Long.MIN_VALUE);
            long right_block = (i < n - 1 ? vp[i + 1][0] : Long.MAX_VALUE);
            intervals[i][0] = Math.max(pos - d, left_block);
            intervals[i][1] = pos;
            intervals[i][2] = pos;
            intervals[i][3] = Math.min(pos + d, right_block);
        }
        int[][] dp = new int[n][2];
        dp[0][0] = getCount(walls, intervals[0][0], intervals[0][1]);
        dp[0][1] = getCount(walls, intervals[0][2], intervals[0][3]);
        for (int i = 1; i < n; i++) {
            long l1 = intervals[i][0], r1 = intervals[i][1];
            long l2 = intervals[i][2], r2 = intervals[i][3];
            long prev_r_left = intervals[i - 1][1];
            long prev_r_right = intervals[i - 1][3];
            int addL_from_left = getCount(walls, Math.max(l1, prev_r_left + 1), r1);
            int addL_from_right = getCount(walls, Math.max(l1, prev_r_right + 1), r1);
            dp[i][0] = Math.max(dp[i - 1][0] + addL_from_left, dp[i - 1][1] + addL_from_right);
            int addR_from_left = getCount(walls, Math.max(l2, prev_r_left + 1), r2);
            int addR_from_right = getCount(walls, Math.max(l2, prev_r_right + 1), r2);
            dp[i][1] = Math.max(dp[i - 1][0] + addR_from_left, dp[i - 1][1] + addR_from_right);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    private int getCount(int[] walls, long l, long r) {
        if (l > r)
            return 0;
        int it1 = lowerBound(walls, l);
        int it2 = upperBound(walls, r);
        return it2 - it1;
    }

    private int lowerBound(int[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    private int upperBound(int[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}