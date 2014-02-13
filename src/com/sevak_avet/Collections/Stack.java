package com.sevak_avet.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack<T> {
	private List<T> stack;

	public Stack() {
		stack = new ArrayList<>();
	}

	public Stack(int size) {
		if(size <= 0) {
			throw new IllegalArgumentException("Size must be positive!");
		}

		stack = new ArrayList<>(size);
	}

	public Stack(T ... elements) {
		stack = new ArrayList<>(Arrays.asList(elements));
	}

	public void push(T element) {
		stack.add(element);
	}

	public T pop() {
		T element = stack.get(stack.size()-1);
		stack.remove(stack.size() - 1);
		return element;
	}

	public T front() {
		return stack.get(stack.size()-1);
	}

	public boolean isEmpty() {
		return stack.size() == 0;
	}
}