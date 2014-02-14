package com.sevak_avet.Tasks;

import com.sevak_avet.Collections.Stack;

public class Task_Stack {
	public static void main(String[] args) {
		Stack<Integer> source = new Stack<>(1,2,5,4,6,3,2,1,4,5,6,7,8,9);
		Stack<Integer> result = new Stack<>();
		Stack<Integer> temp = new Stack<>();

		while(!source.isEmpty()) {
			int pop = source.pop();

			if(pop % 2 == 0) {
				result.push(pop);
			} else {
				temp.push(pop);
			}
		}

		while(!temp.isEmpty()) {
			result.push(temp.pop());
		}

		System.out.println(result);
	}
}
