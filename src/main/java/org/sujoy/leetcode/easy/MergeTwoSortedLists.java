package org.sujoy.leetcode.easy;

import lombok.extern.slf4j.Slf4j;
import org.sujoy.leetcode.ListNode;

@Slf4j
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode f1 = new ListNode(-9);
        ListNode f2 = new ListNode(-3);
        ListNode f4 = new ListNode(13);

        f1.next = f2;
        f2.next = f4;

        ListNode s1 = new ListNode(5);
        ListNode s3 = new ListNode(7);
        ListNode s4 = new ListNode(8);
        ListNode s5 = new ListNode(9);
        ListNode s6 = new ListNode(10);

        s1.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;

        log.info("{}", mergeTwoLists(f1, s1));
    }

    public static ListNode mergeTwoLists(ListNode l1,
                                         ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }
        ListNode finalList   = new ListNode();
        ListNode currentNode = finalList;
        while (true) {
            if (l1.val <= l2.val) {
                currentNode.val = l1.val;
                currentNode.next = new ListNode(0);
                l1 = l1.next;
                currentNode = currentNode.next;
            } else if (l1.val >= l2.val) {
                currentNode.val = l2.val;
                currentNode.next = new ListNode(0);
                l2 = l2.next;
                currentNode = currentNode.next;
            }

            if (l2 == null) {
                currentNode.val = l1.val;
                currentNode.next = l1.next;
                break;
            } else if (l1 == null) {
                currentNode.val = l2.val;
                currentNode.next = l2.next;
                break;
            }
        }
        return finalList;
    }

}


