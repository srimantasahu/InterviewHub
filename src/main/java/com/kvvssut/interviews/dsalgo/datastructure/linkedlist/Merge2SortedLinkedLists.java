package com.kvvssut.interviews.dsalgo.datastructure.linkedlist;

public class Merge2SortedLinkedLists {

    private static Integer prevData = null;

    public static void main(String[] args) {

        LinkedList<Integer> list1 = extractedList1();

        LinkedList<Integer> list2 = extractedList2();

        LinkedList<Integer> sortedList = mergeAndReturn2SortedLinkedList(list1, list2);

        while (sortedList != null) {
            System.out.print(sortedList.getData() + "  ");
            sortedList = sortedList.getNext();
        }

        System.out.println("\n");

        list1 = extractedList1();

        list2 = extractedList2();

        LinkedList<Integer> sortedUniqueList = mergeAndReturn2SortedLinkedListWithUniqueValues(list1, list2);

        while (sortedUniqueList != null) {
            System.out.print(sortedUniqueList.getData() + "  ");
            sortedUniqueList = sortedUniqueList.getNext();
        }
    }

    private static LinkedList<Integer> mergeAndReturn2SortedLinkedList(LinkedList<Integer> list1,
                                                                       LinkedList<Integer> list2) {
        if (list1 == null || list1.isEmpty()) {
            return list2;
        } else if (list2 == null || list2.isEmpty()) {
            return list1;
        } else {
            LinkedList<Integer> start = new LinkedList<Integer>();
            while (list1 != null && list2 != null) {
                if (list1.getData() <= list2.getData()) {
                    list1 = removeAndAddFirstElementToResultList(list1, start);
                } else {
                    list2 = removeAndAddFirstElementToResultList(list2, start);
                }
            }

            if (list1 != null) {
                while (list1 != null) {
                    list1 = removeAndAddFirstElementToResultList(list1, start);
                }
            } else if (list2 != null) {
                while (list2 != null) {
                    list2 = removeAndAddFirstElementToResultList(list2, start);
                }
            }

            return start;
        }
    }

    private static LinkedList<Integer> mergeAndReturn2SortedLinkedListWithUniqueValues(LinkedList<Integer> list1,
                                                                                       LinkedList<Integer> list2) {
        LinkedList<Integer> start = new LinkedList<Integer>();
        if (list1 == null || list1.isEmpty()) {
            while (list2 != null) {
                list2 = removeAndAddFirstUniqueElementToResultList(list2, start);
            }
        } else if (list2 == null || list2.isEmpty()) {
            while (list1 != null) {
                list1 = removeAndAddFirstUniqueElementToResultList(list1, start);
            }
        } else {
            while (list1 != null && list2 != null) {
                if (list1.getData() <= list2.getData()) {
                    list1 = removeAndAddFirstUniqueElementToResultList(list1, start);
                } else {
                    list2 = removeAndAddFirstUniqueElementToResultList(list2, start);
                }
            }

            if (list1 != null) {
                while (list1 != null) {
                    list1 = removeAndAddFirstUniqueElementToResultList(list1, start);
                }
            } else if (list2 != null) {
                while (list2 != null) {
                    list2 = removeAndAddFirstUniqueElementToResultList(list2, start);
                }
            }
        }
        return start;
    }

    private static LinkedList<Integer> removeAndAddFirstElementToResultList(LinkedList<Integer> list,
                                                                            LinkedList<Integer> start) {
        LinkedList<Integer> current = list;
        list = list.getNext();
        current.setNext(null);
        start.add(current);
        return list;
    }

    private static LinkedList<Integer> removeAndAddFirstUniqueElementToResultList(LinkedList<Integer> list,
                                                                                  LinkedList<Integer> start) {
        boolean noDuplicates = true;
        while (list != null) {
            if (list.getData() == prevData) {
                noDuplicates = false;
                list = list.getNext();
            } else {
                break;
            }
        }
        if (noDuplicates) {
            if (list != null) {
                LinkedList<Integer> current = list;
                list = list.getNext();
                current.setNext(null);
                start.add(current);
                prevData = current.getData();
            }
        }
        return list;
    }

    private static LinkedList<Integer> extractedList1() {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(new LinkedList<Integer>(3));
        list1.add(new LinkedList<Integer>(7));
        list1.add(new LinkedList<Integer>(11));
        list1.add(new LinkedList<Integer>(11));
        list1.add(new LinkedList<Integer>(15));
        list1.add(new LinkedList<Integer>(19));
        list1.add(new LinkedList<Integer>(19));
        list1.add(new LinkedList<Integer>(23));
        list1.add(new LinkedList<Integer>(24));
        list1.add(new LinkedList<Integer>(28));
        return list1;
    }

    private static LinkedList<Integer> extractedList2() {
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(new LinkedList<Integer>(8));
        list2.add(new LinkedList<Integer>(11));
        list2.add(new LinkedList<Integer>(11));
        list2.add(new LinkedList<Integer>(12));
        list2.add(new LinkedList<Integer>(16));
        list2.add(new LinkedList<Integer>(16));
        list2.add(new LinkedList<Integer>(20));
        list2.add(new LinkedList<Integer>(24));
        list2.add(new LinkedList<Integer>(28));
        list2.add(new LinkedList<Integer>(32));
        list2.add(new LinkedList<Integer>(32));
        list2.add(new LinkedList<Integer>(36));
        list2.add(new LinkedList<Integer>(40));
        return list2;
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
