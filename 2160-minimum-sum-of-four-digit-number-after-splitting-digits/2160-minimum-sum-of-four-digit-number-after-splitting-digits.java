class Solution {
    public int minimumSum(int num) {
        int arr[]=new int[4];
        int ind=0;
        while(num!=0){
            arr[ind++]=num%10;
            num/=10;
        }
        Arrays.sort(arr);
        int i=arr[0]*10+arr[2];
        int j=arr[1]*10+arr[3];
        return i+j;
    }
}