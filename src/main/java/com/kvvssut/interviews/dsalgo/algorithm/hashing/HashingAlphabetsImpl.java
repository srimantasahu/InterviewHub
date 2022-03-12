package com.kvvssut.interviews.dsalgo.algorithm.hashing;

public class HashingAlphabetsImpl {

    private static final int MAX_BUCKET_SIZE = 10;

    private static String hashtable[][] = new String[26][MAX_BUCKET_SIZE];

    public static void main(String[] args) {
        store("Srimant");
        store("Sipak");
        store("Amit");
        store("Samar");
        store("Nikita");
        store("Akankshya");
        store("Atreye");
        store("Minerva");

        retrieve("Nikita");
        retrieve("Minu");
        retrieve("Sipak");
    }

    private static void store(String name) {
        int hash = getHash(name);
        String hashArray[] = hashtable[hash];
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] == null) {
                hashArray[i] = name;
                break;
            }
        }
    }

    private static void retrieve(String name) {
        String returnValue = "not found";
        int hash = getHash(name);
        String hashArray[] = hashtable[hash];
        for (int i = 0; i < hashArray.length; i++) {
            if (name.equals(hashArray[i])) {
                returnValue = "found";
                break;
            }
        }
        System.out.println(String.format("String - \"%s\", %s in hashtable!", name, returnValue));
    }

    private static int getHash(String name) {
        int charInt = name.charAt(0);
        if (charInt < 95) {
            return charInt - 65;
        } else {
            return charInt - 97;
        }
    }

}
