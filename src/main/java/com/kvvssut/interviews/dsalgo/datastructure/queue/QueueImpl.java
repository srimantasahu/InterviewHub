package com.kvvssut.interviews.dsalgo.datastructure.queue;

public class QueueImpl {

	private static final int SIZE = 100, MAX_QUEUE_SIZE = 10;
	private static int front = 0, rear = 0;

	public static void main(String[] args) {
		int queue[] = new int[SIZE];

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
		
		System.out.println("Size of queue - " + queueSize());

		enqueue(queue, 11);
		
		dequeue(queue);

		dequeue(queue);
		
		dequeue(queue);

		dequeue(queue);
		
		dequeue(queue);

		dequeue(queue);
		
		dequeue(queue);

		dequeue(queue);
		
		dequeue(queue);

		dequeue(queue);
		
		System.out.println("Size of queue - " + queueSize());

		dequeue(queue);
	}

	private static void enqueue(int[] queue, int item) {
		if (queueSize() == MAX_QUEUE_SIZE) {
			System.out.println("Queue Overflow! Please remove some and try again..");
		} else {
			System.out.println("Enqueued item - " + item);
			queue[rear] = item;
			rear++;
		}
	}

	private static void dequeue(int[] queue) {
		if (front == rear) {
			System.out.println("Queue Underflow!. Please add some items and try again..");
		} else {
			System.out.println("Dequeued item - " + queue[front]);
			queue[front] = 0;
			front++;
		}
	}

	private static int queueSize() {
		return rear - front;
	}

}
