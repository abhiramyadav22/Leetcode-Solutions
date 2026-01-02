class Solution {
    public String reorganizeString(String s) {
        int arr[]= new int[26];
        int n=s.length();
        for (int i=0;i<n;i++) {
            arr[s.charAt(i)-'a']++;
        }
        int max=0;
        int val=0;
        for(int i=0;i<26;i++) {
            if(arr[i]>max) {
                max=arr[i];
                val=i;
            }
        }
        if(max>(n+1)/2) {
            return "";
        }
       char[] res = new char[n];
       int index=0;

       while(arr[val]>0) {
        res[index]=(char)(val+'a');
        index+=2;
        arr[val]--;
       }

       for(int i=0;i<26;i++) {
        while(arr[i]>0) {
            if(index>=n) {
                index=1;
            }
        res[index]=(char)(i+'a');
        index+=2;
        arr[i]--;
       }
       }

       return new String(res);
    }
}