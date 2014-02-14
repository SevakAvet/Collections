package com.sevak_avet.Tasks;

import com.sevak_avet.Collections.Queue;

public class Task_Queue {
	public static void main(String[] args) {
		String sentence = "Это просто случайное предложение для тестирования программы";
		String[] words = sentence.split(" ");

		Queue<String> queue = new Queue<>(words);
		Queue<String> temp = new Queue<>(words);
		Queue<String> result = new Queue<>();

		System.out.println(queue);

		int max = -1;
		while(!temp.isEmpty()) {
			String peek = temp.peek();
			max = Math.max(max, peek.length());
		}

		while(!queue.isEmpty()) {
			String cur = queue.peek();

			if(cur.length() != max) {
				result.add(cur);
			}
		}

		System.out.println(result);


	}
}
