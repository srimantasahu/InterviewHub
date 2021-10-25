package com.kvvssut.interviews.dsalgo.datastructure.queue;

public class DEQueueImpl {

	private static final int SIZE = 100, MAX_QUEUE_SIZE = 10;
	private static int front = 0, rear = 0;

	public static void main(String[] args) {
		int queue[] = new int[SIZE];

		enqueue_at_end(queue, 1);

		enqueue_at_end(queue, 2);

		enqueue_at_end(queue, 3);

		enqueue_at_start(queue, 4);

		enqueue_at_end(queue, 5);

		enqueue_at_end(queue, 6);

		enqueue_at_end(queue, 7);

		enqueue_at_start(queue, 8);

		enqueue_at_end(queue, 9);

		enqueue_at_end(queue, 10);

		System.out.println("Size of queue - " + queueSize());

		enqueue_at_start(queue, 11);

		dequeue_at_start(queue);

		dequeue_at_start(queue);

		dequeue_at_start(queue);

		dequeue_at_end(queue);

		dequeue_at_start(queue);

		dequeue_at_start(queue);

		dequeue_at_start(queue);

		dequeue_at_end(queue);

		dequeue_at_start(queue);

		dequeue_at_start(queue);

		System.out.println("Size of queue - " + queueSize());

		dequeue_at_end(queue);
	}

	private static void enqueue_at_end(int[] queue, int item) {
		if (queueSize() == MAX_QUEUE_SIZE) {
			System.out.println("Queue Overflow! Please remove some items and try again..");
		} else {
			System.out.println("Enqueued item at end - " + item);
			queue[rear] = item;
			rear++;
		}
	}

	private static void dequeue_at_start(int[] queue) {
		if (front == rear) {
			System.out.println("Queue Underflow!. Please add some items and try again..");
		} else {
			System.out.println("Dequeued item at start - " + queue[front]);
			queue[front] = 0;
			front++;
		}
	}

	private static void enqueue_at_start(int[] queue, int item) {
		if (queueSize() == MAX_QUEUE_SIZE) {
			System.out.println("Queue Overflow! Please remove some and try again..");
		} else {
			System.out.println("Enqueued item at start - " + item);
			for (int i = rear; i > front; i--) {
				queue[i] = queue[i - 1];
			}
			queue[front] = item;
			rear++;
		}
	}

	private static void dequeue_at_end(int[] queue) {
		if (front == rear) {
			System.out.println("Queue Underflow!. Please add some items and try again..");
		} else {
			rear--;
			System.out.println("Dequeued item at end - " + queue[rear]);
			queue[rear] = 0;
		}
	}

	private static int queueSize() {
		return rear - front;
	}

}
