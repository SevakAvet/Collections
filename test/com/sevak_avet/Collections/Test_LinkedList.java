package com.sevak_avet.Collections;


public class Test_LinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < 10; i++) {
			if(i % 2 == 0) {
				list.pushFront(i);
			} else {
				list.pushBack(i);
			}
		}

		System.out.println(list);

		list.remove(list.size());
		System.out.println(list);

		System.out.println(list.getIndex(7));

		list.insert(2, 100);
		System.out.println(list);

		System.out.println(list.popFront());
		System.out.println(list);

		System.out.println(list.popBack());
		System.out.println(list);

		System.out.println(list.isEmpty());
		System.out.println(list.size());
	}
}
