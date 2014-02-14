package com.sevak_avet.Tasks;

import com.sevak_avet.Collections.LinkedList;

import java.util.*;

public class Task_LinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();

		Random r = new Random();
		Map<Integer, Integer> count = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			int nextNumber = r.nextInt(10);
			linkedList.pushBack(nextNumber);

			if (!count.containsKey(nextNumber)) {
				count.put(nextNumber, 1);
			} else {
				count.put(nextNumber, count.get(nextNumber) + 1);
			}
		}

		System.out.println(linkedList);
		List<Integer> array = new ArrayList<>();

		for (Map.Entry<Integer, Integer> entery : count.entrySet()) {
			List<Integer> indexes = linkedList.getIndex(entery.getKey());
			System.out.println(entery.getKey() + " " + indexes);

			for (int i = 1; i < indexes.size(); ++i) {
				array.add(indexes.get(i));
			}
		}

		Collections.sort(array);
		System.out.println(array);

		int deleted = 0;
		for(int i : array) {
			linkedList.remove(i - deleted++);
		}

		System.out.println(linkedList);
	}
}
