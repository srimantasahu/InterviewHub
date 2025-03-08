package com.kvvssut.interviews.leetcode.medium;

import java.util.*;

/*
Implement the RandomizedSet class:
RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

Example 1:
Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]
Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.

Constraints:
-2^31 <= val <= 2^31 - 1
At most 2 * 10^5 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.
 */
public class InsertDeleteGetRandomO1 {

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(0));
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(2));
        System.out.println(obj.remove(1));
        System.out.println(obj.getRandom());
    }

}

class RandomizedSet {

    Map<Integer, Integer> keyMap;
    List<Integer> indexes;
    Random random;

    public RandomizedSet() {
        keyMap = new HashMap<>();
        indexes = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!keyMap.containsKey(val)) {
            keyMap.put(val, indexes.size());
            indexes.add(indexes.size(), val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (keyMap.containsKey(val)) {
            int remIdx = keyMap.remove(val);
            if (remIdx == indexes.size() - 1) {
                indexes.remove(remIdx);
            } else {
                int lastVal = indexes.removeLast();
                keyMap.put(lastVal, remIdx);
                indexes.set(remIdx, lastVal);
            }
            return true;
        }
        return false;
    }

    public int getRandom() {
        return indexes.get(random.nextInt(indexes.size()));
    }
}