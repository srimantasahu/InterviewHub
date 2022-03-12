package com.kvvssut.interviews.java.threads;

import java.util.LinkedList;

public class VirtualConsumer implements Runnable {

    private LinkedList<String> itemsQueue;

    public VirtualConsumer(LinkedList<String> itemsQueue) {
        this.itemsQueue = itemsQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (itemsQueue) {
            if (itemsQueue.size() == 0) {
                System.out.println("Bucket is empty! So waiting for items to get produced.");
                itemsQueue.wait();
            }

            Thread.sleep(1000);
            String item = itemsQueue.remove();
            System.out.println("Consumed - " + item);
            itemsQueue.notify();
        }
    }

}
