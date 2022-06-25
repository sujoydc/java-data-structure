package org.sujoy.leetcode.medium;


import lombok.extern.slf4j.Slf4j;
import org.sujoy.leetcode.ListNode;
import org.sujoy.leetcode.Util;

@Slf4j
public class SwapNodes {

    public static void main(String[] args) {
        int[] inputs = {1,2,3,4,5,6};

        ListNode head = Util.buildListNode(inputs);
        log.info("Full List:{}", head);

        ListNode swapped = swapNodes(head, 2);
        log.info("New List:{}", swapped);
    }

    public static ListNode swapNodes(ListNode head,
                                     int k) {

        ListNode fast     = head;
        ListNode firstNth;
        ListNode lastNth  = head;

        // move the fast node to kth position
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        firstNth = fast;

        while (true) {
            fast = fast.next;
            if(fast == null) break;
            lastNth = lastNth.next;
        }

        int val1 = firstNth.val;
        firstNth.val = lastNth.val;
        lastNth.val = val1;

        return head;
    }

}
