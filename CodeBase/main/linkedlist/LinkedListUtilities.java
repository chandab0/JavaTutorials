package main.linkedlist;

public class LinkedListUtilities {
	public static boolean isCircularLinkedList(Node head) {
		if (head == null) //An empty linked list is considered as circular
			return true;

		Node node = head.next;
		
		while (node != null && node != head)
			node = node.next;
		return (node == head);
	}
}
