package com.kvvssut.interviews.java.threads;

import java.util.LinkedList;

public class VirtualProducerConsumerDemoWithWaitAndNotify {

    public static final int MAX_BUCKET_SIZE = 5;

    public static void main(String[] args) {
        LinkedList<String> itemsQueue = new LinkedList<String>();

        new Thread(new VirtualProducer(itemsQueue, MAX_BUCKET_SIZE), "Producer").start();
        new Thread(new VirtualConsumer(itemsQueue), "Consumer").start();
    }

}
