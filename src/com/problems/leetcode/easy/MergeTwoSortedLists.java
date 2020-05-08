package com.problems.leetcode.easy;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
//		l1.next = new ListNode(2);
//		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(6);
		
		ListNode merged = mergeTwoLists(l1, l2);
		print(merged);
	}
	private static void print(ListNode merged) {
		while (merged != null) {
			System.out.print(merged.val + " ");
			merged = merged.next;
		}
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode merged = null;
		if (l1 == null) return l2;
		else if (l2 == null) return l1;
		else if (l1.next == null) return insertNode(l1, l2);
		else if (l2.next == null) return insertNode(l2, l1);
		else merged = mergeTwoLists(l1.next, l2.next);
		l1.next = null;
		l2.next = null;
		merged = insertNode(l1, merged);
		merged = insertNode(l2, merged);
		return merged;
	}
	/**
	 * Method to insert a new node in a sorted linked list.
	 * 
	 * @param newNode (node to insert in a sorted linked list)
	 * @param head (the head node of a sorted linked list)
	 * @return ListNode (the head node of a sorted linked list,
	 * in case because of sorting head not gets changed)
	 */
	private static ListNode insertNode(ListNode newNode,
			ListNode head) {
		
		ListNode previous = null;
		ListNode current = head;
		/*
		 * While loop is to identify the position to insert
		 * the new node.
		 **/
		while (current != null && current.val < newNode.val) {
			previous = current;
			current = current.next;
		}
		newNode.next = current;
		if (previous != null) {
			previous.next = newNode;
			return head;
		}
		return newNode;
	}
}
class ListNode {
	
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val, ListNode next) {
		this.val = val; this.next = next;
	}
}