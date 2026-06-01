class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum=mass;
        int n= asteroids.length;
        for(int i=0;i<n;i++) {
            if(asteroids[i]>sum) {
                return false;
            }
            sum+=asteroids[i];
        }
        return true;
    }
}