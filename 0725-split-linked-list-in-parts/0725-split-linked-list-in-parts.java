class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {

        int n = 0;
        ListNode temp = head;
        while(temp != null) {
            n++;
            temp = temp.next;
        }
        int size = n / k;
        int extra = n % k;
        ListNode[] ans = new ListNode[k];
        temp = head;
        for(int i = 0; i < k; i++) {
            ans[i] = temp;
            int curr = size + (extra > 0 ? 1 : 0);
            if(extra > 0) extra--;
            for(int j = 1; j < curr; j++) {
                temp = temp.next;
            }
            if(temp != null) {
                ListNode next = temp.next;
                temp.next = null;
                temp = next;
            }
        }
        return ans;
    }
}