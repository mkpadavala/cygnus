package com.padavala.loom.others;

public class Queue<T> {

	private Node<T> top;
	
	public void push(T value){

		if(top == null){
			top = new Node<T>(value);
		}else{
			Node<T> node = new Node<T>(value);
			node.setNext(top);
			top.setNext(node);
		}
	}
	
	public T pop(){
		Node<T> node = top.getNext();
		if(node == null){
			return null;
		}
		T value = node.getValue();
		top.setNext(node.getNext());
		return value;
	}
	
	private static class Node<T> {

		private T value;
		private Node<T> next;
		
		
		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Node(T value) {
			super();
			this.value = value;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

	}

}
