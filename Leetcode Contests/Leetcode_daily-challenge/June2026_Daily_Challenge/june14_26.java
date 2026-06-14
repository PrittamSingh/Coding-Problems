public class june14_26 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static int pairSum(ListNode head) {
        // T.C - O(N)   S.C - O(N)
        // List<Integer> list = new ArrayList<>();
        // while(head != null){
        //     list.add(head.val);
        //     head = head.next;
        // }
        // int n = list.size();
        // int sum = Integer.MIN_VALUE;
        // for(int i = 0 ; i < n / 2 ; i++){
        //     sum = Math.max(sum, list.get(i) + list.get(n - 1 - i));
        // }
        // return sum;


        // T.C - O(N)   S.C - O(1)
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        int maxSum = 0;
        ListNode first = head;
        ListNode second = prev;
        while(second != null){
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(pairSum(head));
    }
}
