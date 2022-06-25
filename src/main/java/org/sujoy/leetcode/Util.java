package org.sujoy.leetcode;

public class Util {

    public static ListNode buildListNode(int[] list) {
        ListNode head    = new ListNode();
        ListNode current = head;

        for (int i = 0; i < list.length; i++) {
            current.val = list[i];
            if (i + 1 == list.length) {
                current.next = null;
            } else {
                current.next = new ListNode();
                current = current.next;
            }
        }
        return head;
    }
}
