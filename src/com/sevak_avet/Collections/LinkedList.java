package com.sevak_avet.Collections;

public class LinkedList<T> {
	private Node curNode;
	private Node firstNode;
	private Node lastNode;
	private int size = 0;

	public LinkedList() {
		curNode = Node.EMPTY_NODE;
		firstNode = Node.EMPTY_NODE;
		lastNode = Node.EMPTY_NODE;
	}

	public void insert(int index, T element) {
		if (index < 1 || index > size) {
			throw new UnsupportedOperationException();
		}

		if (index == 1) {
			pushBack(element);
		} else if (index == size) {
			pushFront(element);
		} else {
			int count = 1;
			curNode = firstNode;
			while (curNode != null && count != index) {
				curNode = curNode.getNext();
				count++;
			}

			Node newNode = new Node(element);
			curNode.getPrevious().setNext(newNode);
			newNode.setPrevious(curNode.getPrevious());
			curNode.setPrevious(newNode);
			newNode.setNext(curNode);
		}
	}

	public void remove(int index) {
		if (index < 1 || index > size) {
			throw new UnsupportedOperationException();
		}

		if (index == 1) {
			popFront();
		} else if (index == size) {
			popBack();
		} else {
			int count = 1;
			curNode = firstNode;
			while (curNode != null && count != index) {
				curNode = curNode.getNext();
				count++;
			}

			curNode.getPrevious().setNext(curNode.getNext());
			curNode.getNext().setPrevious(curNode.getPrevious());
		}
	}

	public int getIndex(T element) {
		curNode = firstNode;
		int index = 1;

		while(curNode != null && curNode.getElement() != null && !curNode.getElement().equals(element)) {
			curNode = curNode.getNext();
			++index;
		}

		return index;
	}

	public void pushFront(T element) {
		Node newNode = new Node(element);

		if (firstNode.equals(Node.EMPTY_NODE)) {
			firstNode = newNode;
			lastNode = newNode;
		} else {
			newNode.setNext(firstNode);
			firstNode = newNode;
			newNode.getNext().setPrevious(firstNode);
		}

		++size;
	}

	public void pushBack(T element) {
		Node newNode = new Node(element);

		if (firstNode.equals(Node.EMPTY_NODE)) {
			firstNode = newNode;
			lastNode = newNode;
		} else {
			lastNode.setNext(newNode);
			newNode.setPrevious(lastNode);
			lastNode = newNode;
		}

		++size;
	}

	public Node popFront() {
		if (firstNode.equals(Node.EMPTY_NODE)) {
			throw new UnsupportedOperationException();
		}

		Node temp = firstNode;

		if (firstNode.getNext() != null && !firstNode.getNext().equals(Node.EMPTY_NODE)) {
			firstNode.getNext().setPrevious(Node.EMPTY_NODE);
		}

		firstNode = firstNode.getNext();
		--size;

		return temp;
	}

	public Node popBack() {
		if (lastNode.equals(Node.EMPTY_NODE)) {
			throw new UnsupportedOperationException();
		}

		Node temp = lastNode;
		if (!lastNode.getPrevious().equals(Node.EMPTY_NODE)) {
			lastNode.getPrevious().setNext(Node.EMPTY_NODE);
		}

		lastNode = lastNode.getPrevious();
		--size;
		return temp;
	}


	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void clear() {
		while (!isEmpty()) {
			popFront();
		}
	}

	public String reversedString() {
		return new StringBuilder(toString()).reverse().toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (size == 0 || (firstNode != null && firstNode.equals(Node.EMPTY_NODE))) {
			sb.append("Linked list is empty");
			return sb.toString();
		}

		curNode = firstNode;
		while (curNode != null && curNode.getElement() != null && !curNode.equals(Node.EMPTY_NODE)) {
			sb.append(curNode.getElement().toString());
			sb.append(" ");
			curNode = curNode.getNext();
		}

		return sb.toString().trim();
	}

	public static class Node<T> {
		public static final Node EMPTY_NODE = new Node();

		private T element;
		private Node next;
		private Node previous;

		private Node() {
		}

		;

		public Node(T element) {
			this.element = element;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		@Override
		public String toString() {
			return element.toString();
		}
	}
}