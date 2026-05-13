class Solution {
    public int[] countPoints(int[][] p, int[][] q) {
        int ans[] = new int[q.length];
        for(int i = 0; i < q.length; i++){
            int c = 0;
            int x = q[i][0];
            int y = q[i][1];
            int r = q[i][2] * q[i][2]; 
            for(int[] a : p){
                int dx = a[0] - x;
                int dy = a[1] - y;
                if(r >= dx * dx + dy * dy) c++;
            }
            ans[i] = c;
        }
        return ans;
    }
}