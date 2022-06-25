package org.sujoy.leetcode.medium;

import lombok.extern.slf4j.Slf4j;
import org.sujoy.leetcode.ListNode;
import org.sujoy.leetcode.Util;

@Slf4j
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 4, 5};

        ListNode head = Util.buildListNode(inputs);
        log.info("Full List:{}", head);

        ListNode swapped = removeNthFromEnd(head, 1);
        log.info("New List:{}", swapped);
    }

    public static ListNode removeNthFromEnd(ListNode head,
                                            int n) {
        ListNode fast   = head;
        ListNode slow   = head;
        ListNode before = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            if (fast.next == null) {
                before = slow;
            }
            slow = slow.next;
            fast = fast.next;
        }

        // There are 3 conditions:

        // If Slow is the first node and the only node
        if (slow == head && slow.next == null) {
            return null;
        } else if(slow == head && slow.next != null){ // First Node but not the only node
            head = head.next;
        }else { // Not an edge node
            before.next = slow.next;
        }

        return head;
    }

}
