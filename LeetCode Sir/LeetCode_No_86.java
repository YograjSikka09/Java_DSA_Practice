class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);
        ListNode small = smallDummy;
        ListNode big = bigDummy;
        ListNode curr = head;

        while(curr!=null){
            if(curr.val < x){
                small.next = curr;
                small = small.next;
            }
            else
            {
                big.next = curr;
                big = big.next;
            }
            curr = curr.next;
        }

        big.next = null;
        small.next = bigDummy.next;

        return smallDummy.next;
    }
}