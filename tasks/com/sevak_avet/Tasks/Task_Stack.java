package com.sevak_avet.Tasks;

import com.sevak_avet.Collections.Stack;

public class Task_Stack {
	public static void main(String[] args) {
		Stack<Integer> source = new Stack<>(1,2,5,4,6,3,2,1,4,5,6,7,8,9);
		Stack<Integer> even = new Stack<>();
		Stack<Integer> odd = new Stack<>();

		while(!source.isEmpty()) {
			int element = source.pop();

			if(element % 2 == 0) {
				even.push(element);
			} else {
				odd.push(element);
			}
		}

		System.out.println(source);
		System.out.println(even);
		System.out.println(odd);
	}
}
