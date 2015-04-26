package com.code.interview;

/**
 * 计算链表的长度（需要考虑存在环的情况）
 */
public class CountLinkList {
    public int countLinkedListLength(LinkedNode root) {
        if (root == null) {
            return 0;
        }
        if (root.next == null) {
            return 1;
        }

        LinkedNode slow = root;
        LinkedNode fast = root;
        int count = 0;

        // test if list has a loop
        while (fast != null && fast.next != null) {
            count++;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // list do not have a loop
        if (fast == null || fast.next == null) {
            while (slow != null) {
                count++;
                slow = slow.next;
            }
            return count;
        }

        // list do have a loop
        if (fast == slow) {
            LinkedNode start1 = root;
            LinkedNode start2 = slow;
            count = 1;

            // get loop start node
            while (start1 != start2) {
                count++;
                start1 = start1.next;
                start2 = start2.next;
            }

            LinkedNode interNode = start1;
            start1 = start1.next;
            while (start1 != interNode) {
                count++;
                start1 = start1.next;
            }
        }

        return count;
    }

    static class LinkedNode {
        int val;
        LinkedNode next;

        public LinkedNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        LinkedNode root = new LinkedNode(1);
        LinkedNode two = new LinkedNode(2);
        LinkedNode three = new LinkedNode(3);
        LinkedNode four = new LinkedNode(4);
        LinkedNode five = new LinkedNode(5);
        LinkedNode six = new LinkedNode(6);
        LinkedNode seven = new LinkedNode(7);

        root.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = seven;

        CountLinkList test = new CountLinkList();
        int count = test.countLinkedListLength(root);
        System.out.println("count = " + count);
    }
}
