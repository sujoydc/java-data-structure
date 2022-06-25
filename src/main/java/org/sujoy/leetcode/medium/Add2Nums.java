package org.sujoy.leetcode.medium;

import lombok.extern.slf4j.Slf4j;
import org.sujoy.leetcode.ListNode;

@Slf4j
public class Add2Nums {

    public static void main(String[] args) {
        ListNode f1 = new ListNode(9);
        ListNode f2 = new ListNode(9);
        ListNode f4 = new ListNode(9);
        ListNode f5 = new ListNode(9);
        ListNode f6 = new ListNode(9);

        f1.next = f2;
        f2.next = f4;
        f4.next = f5;
        f5.next = f6;

        ListNode s1 = new ListNode(9);
        ListNode s3 = new ListNode(9);
        ListNode s4 = new ListNode(9);

        s1.next = s3;
        s3.next = s4;

        log.info("{}", addTwoNumbers(f1, s1));
    }


    public static ListNode addTwoNumbers(ListNode l1,
                                         ListNode l2) {

        ListNode retVal    = new ListNode();
        ListNode head      = retVal;
        int      carryOver = 0;

        while (true) {
            int firstVal = 0;
            int secVal   = 0;

            if (l1 != null) {
                firstVal = l1.val;
            }
            if (l2 != null) {
                secVal = l2.val;
            }

            int temp = firstVal + secVal + carryOver;
            retVal.val = temp % 10;
            carryOver = temp / 10;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;

            if (l1 == null && l2 == null) {
                if (carryOver > 0) {
                    retVal.next = new ListNode();
                    retVal.next.val = carryOver;
                } else {
                    retVal = null;
                }
                break;
            }

            retVal.next = new ListNode();
            retVal = retVal.next;
        }

        return head;
    }
}

