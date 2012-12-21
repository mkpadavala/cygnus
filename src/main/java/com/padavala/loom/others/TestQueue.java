package com.padavala.loom.others;

public class TestQueue {

	
	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		queue.push("First");
		printQueue(queue);
		queue.push("Second");
		queue.push("Third");
		queue.push("Fourth");
		queue.push("Fifth");
		printQueue(queue);
		queue.pop();
		queue.pop();
		printQueue(queue);
		queue.pop();
		queue.pop();
		queue.pop();
		printQueue(queue);
	}
	
	private static <T> void printQueue(Queue<T> queue){
		if(queue == null){
			return;
		}
		T value;
		while((value = queue.pop()) != null){
			System.out.println(value.toString());
		}
		
		System.out.println("===================");
	}

}
