package com.code.interview;

/**
 * 合并两个已经排序的链表
 * 
 * @author Vivian
 * 
 */
public class MergeSortedLists_17 {

	public ListNode merge(ListNode headA, ListNode headB) {
		if (headA == null) {
			return headB;
		}
		if (headB == null) {
			return headA;
		}

		ListNode mergeHead;
		if (headA.val < headB.val) {
			mergeHead = headA;
			headA.next = merge(headA.next, headB);
		} else {
			mergeHead = headB;
			headB.next = merge(headA, headB.next);
		}

		return mergeHead;
	}

	public static void main(String[] args) {

	}

}
