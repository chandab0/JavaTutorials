package test.linkedlist;

import static org.junit.Assert.assertEquals;
import static main.linkedlist.LinkedListUtilities.isCircularLinkedList;

import org.junit.Test;

import main.linkedlist.Node;

public class LinkedListUtilitiesTest {
	@Test
	public void whenIsCircularLinkedListInvoked_givenAnCircularLinkedList_returnTrue() {
		try {
			Node node = new Node(1);
			node.next = new Node(2);
			node.next.next = new Node(3);
			node.next.next.next = node;
			assertEquals(isCircularLinkedList(node), true);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void whenIsCircularLinkedListInvoked_givenAnNonCircularLinkedList_returnFalse() {
		try {
			Node node = new Node(1);
			node.next = new Node(2);
			node.next.next = new Node(3);
			node.next.next.next = null;
			assertEquals(isCircularLinkedList(node), false);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test
	public void whenIsCircularLinkedListInvoked_givenNull_returnTrue() {
		try {
			assertEquals(isCircularLinkedList(null), true);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
