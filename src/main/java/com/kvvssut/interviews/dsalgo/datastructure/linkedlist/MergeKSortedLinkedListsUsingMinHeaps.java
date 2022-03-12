package com.kvvssut.interviews.dsalgo.datastructure.linkedlist;

public class MergeKSortedLinkedListsUsingMinHeaps {

    public static void main(String[] args) {

        LinkedList<Integer> list1 = extractedList1();

        LinkedList<Integer> list2 = extractedList2();

        LinkedList<Integer> list3 = extractedList3();

        LinkedList<Integer> list4 = extractedList4();

        LinkedList<Integer> list5 = extractedList5();

        int size1 = list1.size(), size2 = list2.size(), size3 = list3.size(), size4 = list4.size(),
                size5 = list5.size();

        int maxSize = 0, totalSize = 0;

        if (size1 > maxSize) {
            maxSize = size1;
        }
        if (size2 > maxSize) {
            maxSize = size2;
        }
        if (size3 > maxSize) {
            maxSize = size3;
        }
        if (size4 > maxSize) {
            maxSize = size4;
        }
        if (size5 > maxSize) {
            maxSize = size5;
        }

        totalSize = size1 + size2 + size3 + size4 + size5;

        MinHeap minHeap = new MinHeap(totalSize);

        for (int i = 0; i < maxSize; i++) {
            if (size1 > i) {
                minHeap.insertKey(list1.getData());
                list1 = list1.getNext();
            }
            if (size2 > i) {
                minHeap.insertKey(list2.getData());
                list2 = list2.getNext();
            }
            if (size3 > i) {
                minHeap.insertKey(list3.getData());
                list3 = list3.getNext();
            }
            if (size4 > i) {
                minHeap.insertKey(list4.getData());
                list4 = list4.getNext();
            }
            if (size5 > i) {
                minHeap.insertKey(list5.getData());
                list5 = list5.getNext();
            }
        }

        for (int i = 0; i < totalSize; i++) {
            System.out.println(minHeap.extractMin());
        }
    }

    private static LinkedList<Integer> extractedList1() {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(new LinkedList<Integer>(3));
        list1.add(new LinkedList<Integer>(7));
        list1.add(new LinkedList<Integer>(11));
        list1.add(new LinkedList<Integer>(15));
        list1.add(new LinkedList<Integer>(19));
        list1.add(new LinkedList<Integer>(23));
        return list1;
    }

    private static LinkedList<Integer> extractedList2() {
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(new LinkedList<Integer>(8));
        list2.add(new LinkedList<Integer>(12));
        list2.add(new LinkedList<Integer>(16));
        list2.add(new LinkedList<Integer>(20));
        list2.add(new LinkedList<Integer>(24));
        list2.add(new LinkedList<Integer>(28));
        list2.add(new LinkedList<Integer>(32));
        list2.add(new LinkedList<Integer>(36));
        list2.add(new LinkedList<Integer>(40));
        return list2;
    }

    private static LinkedList<Integer> extractedList3() {
        LinkedList<Integer> list3 = new LinkedList<Integer>();
        list3.add(new LinkedList<Integer>(1));
        list3.add(new LinkedList<Integer>(5));
        list3.add(new LinkedList<Integer>(9));
        list3.add(new LinkedList<Integer>(13));
        list3.add(new LinkedList<Integer>(17));
        list3.add(new LinkedList<Integer>(21));
        list3.add(new LinkedList<Integer>(25));
        list3.add(new LinkedList<Integer>(29));
        list3.add(new LinkedList<Integer>(33));
        list3.add(new LinkedList<Integer>(37));
        return list3;
    }

    private static LinkedList<Integer> extractedList4() {
        LinkedList<Integer> list4 = new LinkedList<Integer>();
        list4.add(new LinkedList<Integer>(2));
        list4.add(new LinkedList<Integer>(6));
        list4.add(new LinkedList<Integer>(10));
        list4.add(new LinkedList<Integer>(14));
        list4.add(new LinkedList<Integer>(18));
        list4.add(new LinkedList<Integer>(22));
        list4.add(new LinkedList<Integer>(26));
        list4.add(new LinkedList<Integer>(30));
        list4.add(new LinkedList<Integer>(34));
        list4.add(new LinkedList<Integer>(38));
        list4.add(new LinkedList<Integer>(42));
        return list4;
    }

    private static LinkedList<Integer> extractedList5() {
        LinkedList<Integer> list5 = new LinkedList<Integer>();
        list5.add(new LinkedList<Integer>(5));
        list5.add(new LinkedList<Integer>(14));
        list5.add(new LinkedList<Integer>(19));
        list5.add(new LinkedList<Integer>(24));
        list5.add(new LinkedList<Integer>(29));
        list5.add(new LinkedList<Integer>(34));
        list5.add(new LinkedList<Integer>(39));
        list5.add(new LinkedList<Integer>(44));
        list5.add(new LinkedList<Integer>(49));
        return list5;
    }

    static class MinHeap {
        private int harr[];
        private int capacity;
        private int heap_size;

        public MinHeap(int capacity) {
            this.harr = new int[capacity];
            this.capacity = capacity;
            this.heap_size = 0;
        }

        // Returns the minimum key (key at root) from min heap
        public int getMin() {
            return harr[0];
        }

        // Inserts a new key 'k'
        public void insertKey(int key) {
            if (heap_size == capacity) {
                System.out.println("Overflow : couldn't insert key!");
                return;
            }

            // First insert the new key at the end
            heap_size++;
            int i = heap_size - 1;
            harr[i] = key;

            // Fix the min heap property if it is violated
            while (i != 0 && harr[parent(i)] > harr[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        // Decreases value of key at index 'i' to new_val. It is assumed that
        // new_val is smaller than harr[i].
        public void decreaseKey(int i, int new_val) {
            harr[i] = new_val;
            while (i != 0 && harr[parent(i)] > harr[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        // Method to remove minimum element (or root) from min heap
        public int extractMin() {
            if (heap_size <= 0) {
                return Integer.MAX_VALUE;
            } else if (heap_size == 1) {
                heap_size--;
                return harr[0];
            }

            int root = harr[0];
            harr[0] = harr[heap_size - 1];
            heap_size--;
            minHeapify(0);

            return root;
        }

        // A recursive method to heapify a subtree with root at given index
        // This method assumes that the subtrees are already heapified
        public void minHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;

            if (l < heap_size && harr[l] < harr[smallest]) {
                smallest = l;
            }
            if (r < heap_size && harr[r] < harr[smallest]) {
                smallest = r;
            }
            if (smallest != i) {
                swap(i, smallest);
                minHeapify(smallest);
            }
        }

        // This function deletes key at index i. It first reduced value to minus
        // infinite, then calls extractMin()
        public void deleteKey(int i) {
            decreaseKey(i, Integer.MIN_VALUE);
            extractMin();
        }

        public int parent(int i) {
            return (i - 1) / 2;
        }

        public int left(int i) {
            return (2 * i + 1);
        }

        public int right(int i) {
            return (2 * i + 2);
        }

        public void swap(int i, int j) {
            int dummy = harr[i];
            harr[i] = harr[j];
            harr[j] = dummy;
        }

    }

    static class LinkedList<K> {
        public K data;
        public LinkedList<K> next;

        public LinkedList() {
        }

        public LinkedList(K data) {
            this.data = data;
        }

        public K getData() {
            return this.data;
        }

        public void setData(K data) {
            this.data = data;
        }

        public LinkedList<K> getNext() {
            return next;
        }

        public void setNext(LinkedList<K> next) {
            this.next = next;
        }

        public void add(LinkedList<K> node) {
            if (this.data == null) {
                this.data = node.getData();
                this.next = node.getNext();
            } else {
                LinkedList<K> last = this;
                while (last.getNext() != null) {
                    last = last.getNext();
                }
                last.setNext(node);
            }
        }

        public boolean isEmpty() {
            return this.data == null;
        }

        public int size() {
            LinkedList<K> node = this;
            int size = 0;
            while (node != null) {
                size++;
                node = node.getNext();
            }
            return size;
        }

    }
}