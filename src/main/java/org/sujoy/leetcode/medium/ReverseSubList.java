package org.sujoy.leetcode.medium;

import lombok.extern.slf4j.Slf4j;
import org.sujoy.leetcode.ListNode;
import org.sujoy.leetcode.Util;

@Slf4j
public class ReverseSubList {

    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 4, 5, 6};

        ListNode head = Util.buildListNode(inputs);
        log.info("Full List:{}", head);

        ListNode rev = reverseBetween(head, 2, 6);
        log.info("Rev List:{}", rev);
    }


    public static ListNode reverseBetween(ListNode head,
                                          int left,
                                          int right) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        ListNode leftBoundary  = null;
        ListNode leftTail      = head;
        ListNode rightBoundary = null;

        int index = 1;
        while (curr != null) {
            if ((left - 1) == index) {
                leftBoundary = curr;
                leftTail = curr.next;
            }

            if (index == (right + 1)) {
                rightBoundary = curr;
            }

            if (index >=  left && index <= right) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            } else {
                curr = curr.next;
            }

            index += 1;
        }

        if (leftBoundary != null && rightBoundary != null) {
            leftBoundary.next = prev;
            leftTail.next = rightBoundary;
            return head;
        }else if (leftBoundary == null && rightBoundary != null) {
            leftTail.next = rightBoundary;
            return prev;
        }else if (leftBoundary != null && rightBoundary == null) {
            leftBoundary.next = prev;
            return head;
        }

        return prev;
    }

}
