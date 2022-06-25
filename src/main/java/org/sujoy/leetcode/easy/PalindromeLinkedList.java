package org.sujoy.leetcode.easy;

import lombok.extern.slf4j.Slf4j;
import org.sujoy.leetcode.ListNode;
import org.sujoy.leetcode.Util;

@Slf4j
public class PalindromeLinkedList {

    public static int size = 0;

    public static void main(String[] args) {
        int[] inputs = {7, 1, 5, 1, 7, 7, 7, 1, 5, 1, 7};
        //int[]    inputs = {1,2,3,4,5,6,7,8,9,10};

        ListNode head = Util.buildListNode(inputs);
        log.info("Full List:{}", head);

        log.info("Palindrome? = {}", isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode middle = getMiddle(head);
        log.info("Middle:{}", middle);

        if (size % 2 != 0) {
            middle = middle.next;
        }

        ListNode revHead = reverse(middle);
        log.info("Reverse:{}", revHead);

        while (revHead != null) {
            if (head.val != revHead.val) {
                return false;
            }
            revHead = revHead.next;
            head = head.next;
        }
        return true;
    }


    public static ListNode reverse(ListNode l1) {

        if (l1 == null || l1.next == null) {
            return l1;
        }

        ListNode prev    = null;
        ListNode current = l1;
        ListNode next    = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static ListNode getMiddle(ListNode l1) {
        ListNode slow = l1;
        ListNode fast = l1;

        if (l1 != null) {
            size = 1;
            if (l1.next != null) {
                while (true) {
                    if (fast.next.next != null) {
                        fast = fast.next.next;
                        slow = slow.next;
                        size += 2;
                    } else {
                        slow = slow.next;
                        size += 1;
                        break;
                    }

                    if (fast.next == null) {
                        break;
                    }
                }
            }
        }
        log.info("Size:{}", size);
        return slow;
    }



}

