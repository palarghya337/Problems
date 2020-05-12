package com.problems.leetcode.easy;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		
		ListNode reversed = reverseList(list);
		while (reversed != null) {
			System.out.print(reversed.val + " ");
			reversed = reversed.next;
		}
	}
	public static ListNode reverseList(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		ListNode reversed = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return reversed;
	}
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) { this.val = val; }
	}
}
