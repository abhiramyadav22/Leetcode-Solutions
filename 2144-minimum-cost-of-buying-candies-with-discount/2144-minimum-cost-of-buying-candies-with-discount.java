class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans=0;
        int took=0;
        for(int i=cost.length-1;i>=0;i--){
            if(took==2){
                took=0;


            }else{
                ans+=cost[i];
                took++;
            }
        }
        return ans;
    }
}