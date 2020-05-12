package com.problems.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(2);
		list.next.next.next = new ListNode(1);
		
		System.out.println(isPalindrome2(list));
	}
	public static boolean isPalindrome2(ListNode head) {
		
		ListNode current = head;
		ListNode reversedList = reverse(current);
		
		while (head != null) {
			if (head.val != reversedList.val) {
				return false;
			}
			head = head.next;
			reversedList = reversedList.next;
		}
		return true;
	}
	private static ListNode reverse(ListNode current) {
		
		ListNode reversedList = null;
		while (current != null) {
			
			ListNode temp = reversedList;
			reversedList = new ListNode(current.val);
			reversedList.next = temp;
			current = current.next;
		}
		return reversedList;
	}
	/**
	 * Need to improve the code.
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(ListNode head) {
		
		List<ListNode> listOfNodes = new ArrayList<>();
		ListNode current = head;
		while (current != null) {
			listOfNodes.add(current);
			current = current.next;
		}
		
		boolean isPalindrome = true;
		int i = 0;
		int j = listOfNodes.size() - 1;
		while (i < j) {
			if (listOfNodes.get(i).val !=
					listOfNodes.get(j).val) {
				isPalindrome = false;
				break;
			}
			i++;
			j--;
		}
		return isPalindrome;
	}
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) { this.val = val; }
	}
}