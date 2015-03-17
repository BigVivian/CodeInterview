package com.code.interview;

/**
 * 在O(1)时间删除一个链表中的某个结点<br>
 * 
 * 使用复制value达到目标,默认要删除的结点一定在链表中
 * 
 * @author Vivian
 * 
 */
public class DeleteNodeIn1Time_13 {

	public void deleteNode(ListNode head, ListNode deleteNode) {

		if (head == null || deleteNode == null) {
			return;
		}

		// 不是尾结点
		if (deleteNode.next != null) {
			ListNode nextNode = deleteNode.next;
			deleteNode.val = nextNode.val;
			deleteNode.next = nextNode.next;
			nextNode = null;
		}
		// 只有一个节点的情况
		else if (deleteNode == head) {
			deleteNode = null;
			head = null;
		}
		// 要删除的是尾结点
		else {
			ListNode cur = head;
			while (cur.next != deleteNode) {
				cur = cur.next;
			}

			cur.next = null;
			deleteNode = null;
		}
	}

	public static void main(String[] args) {

	}

}
