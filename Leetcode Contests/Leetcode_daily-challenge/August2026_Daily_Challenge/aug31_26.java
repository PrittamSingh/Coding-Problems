import java.util.*;
public class aug31_26 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public static int[] nodesBetweenCriticalPoints(ListNode head){
        int firstCriticalpointPosition = -1;
        int prevCriticalpointPosition = -1;
        ListNode curr = head.next;
        ListNode prev = head;
        int idx = 1;
        int minDist = Integer.MAX_VALUE;
        while(curr.next != null){
            boolean CP = false;
            if((curr.val < prev.val && curr.val < curr.next.val) || (curr.val > prev.val && curr.val > curr.next.val)){
                CP = true;
            }
            if(CP && firstCriticalpointPosition == -1){
                firstCriticalpointPosition = idx;
                prevCriticalpointPosition = idx;
            }
            else if(CP){
                minDist = Math.min(minDist, idx - prevCriticalpointPosition);
                prevCriticalpointPosition = idx;
            }
            idx++;
            prev = curr;
            curr = curr.next;
        }
        if(minDist == Integer.MAX_VALUE){
            return new int[]{-1, -1};
        }
        int maxDist = prevCriticalpointPosition - firstCriticalpointPosition;
        return new int[]{minDist, maxDist};
    }
    static ListNode createList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for(int i = 1 ; i < arr.length ; i++){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 5, 1, 2};
        ListNode head = createList(arr);
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));
    }
}
