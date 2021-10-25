package com.kvvssut.interviews.dsalgo.datastructure.queue;

public class CircularQueue {

	private static final int QUEUE_SIZE = 10;
	private static int front = 0, rear = 0, count = 0;

	public static void main(String[] args) {
		int queue[] = new int[QUEUE_SIZE];

		enqueue(queue, 1);

		enqueue(queue, 2);

		enqueue(queue, 3);

		enqueue(queue, 4);

		enqueue(queue, 5);

		enqueue(queue, 6);

		enqueue(queue, 7);

		enqueue(queue, 8);

		enqueue(queue, 9);

		enqueue(queue, 10);
		
		dequeue(queue);
		
		dequeue(queue);

		System.out.println("Size of queue - " + count);

		enqueue(queue, 11);

		enqueue(queue, 12);

		dequeue(queue);

		dequeue(queue);

		dequeue(queue);

		dequeue(queue);

		dequeue(queue);

		dequeue(queue);

		dequeue(queue);

		dequeue(queue);

		System.out.println("Size of queue - " + count);

		dequeue(queue);

		dequeue(queue);
	}

	private static void enqueue(int[] queue, int item) {
		if (count == QUEUE_SIZE) {
			System.out.println("Queue Overflow! Please remove some and try again..");
		} else {
			System.out.println("Enqueued item - " + item);
			queue[rear] = item;
			rear = (rear + 1) % QUEUE_SIZE;
			count++;
		}
	}

	private static void dequeue(int[] queue) {
		if (count == 0) {
			System.out.println("Queue Underflow!. Please add some items and try again..");
		} else {
			System.out.println("Dequeued item - " + queue[front]);
			queue[front] = 0;
			front = (front + 1) % QUEUE_SIZE;
			count--;
		}
	}

}
