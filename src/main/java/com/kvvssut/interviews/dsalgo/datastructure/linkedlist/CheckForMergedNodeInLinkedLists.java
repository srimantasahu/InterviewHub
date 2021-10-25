package com.kvvssut.interviews.dsalgo.datastructure.linkedlist;

public class CheckForMergedNodeInLinkedLists {

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(new LinkedList<Integer>(3));
		list1.add(new LinkedList<Integer>(7));
		list1.add(new LinkedList<Integer>(11));

		LinkedList<Integer> node15 = new LinkedList<Integer>(15);
		LinkedList<Integer> node19 = new LinkedList<Integer>(19);
		LinkedList<Integer> node23 = new LinkedList<Integer>(23);
		list1.add(node15);
		list1.add(node19);
		list1.add(node23);

		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(new LinkedList<Integer>(8));
		list2.add(new LinkedList<Integer>(12));
		list2.add(node15);

		System.out.println("Merged node data is : " + getMergedNodeDataWithLengthCheck(list1, list2));

	}

	public static int getMergedNodeDataWithLengthCheck(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		if (list1 != null && list2 != null && !list1.isEmpty() && !list2.isEmpty()) {
			int len1 = list1.size();
			int len2 = list2.size();

			if (len1 > len2) {
				int diff = len1 - len2;
				for (int i = 0; i < diff; i++) {
					list1 = list1.getNext();
				}
			} else if (len1 < len2) {
				int diff = len2 - len1;
				for (int i = 0; i < diff; i++) {
					list2 = list2.getNext();
				}
			}

			while (list1 != null) {
				if (list1 != list2) {
					list1 = list1.getNext();
					list2 = list2.getNext();
				} else {
					return list1.getData();
				}
			}

		}

		return -1;
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