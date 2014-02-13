package com.sevak_avet.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queue<T> {
	private List<T> queue;

	public Queue() {
		queue = new ArrayList<>();
	}

	public Queue(T ... elements) {
		queue = new ArrayList<>(Arrays.asList(elements));
	}

	public void add(T element) {
		queue.add(queue.size(), element);
	}

	public T head() {
		return queue.get(0);
	}

	public T peek() {
		T element = queue.get(0);
		queue.remove(0);
		return element;
	}


	public boolean isEmpty() {
		return queue.size() == 0;
	}

	@Override
	public String toString() {
		return queue.toString();
	}
}