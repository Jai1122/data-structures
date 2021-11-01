package com.ds.strings;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AdjacentChars {

    private static void rearrangeString(String str) {
        int n = str.length();
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[str.charAt(i) - 'a']++;
        }
        PriorityQueue<Key> priorityQueue = new PriorityQueue<>(new KeyComparator());

        for (char c = 'a'; c <= 'z'; c++) {
            int val = c - 'a';
            if (count[val] > 0) {
                priorityQueue.add(new Key(c, count[val]));
            }
        }

        str = "";
        Key prev = new Key('#', -1);

        while (!priorityQueue.isEmpty()) {
            Key k = priorityQueue.poll();
            str = str + k.ch;

            if (prev.freq > 0)
                priorityQueue.add(prev);

            (k.freq)--;
            prev = k;
        }
        if (n != str.length())
            System.out.println("Invalid String");
        else
            System.out.println(str);
    }

    public static void main(String[] args) {
        rearrangeString("bbbaa");
    }

    static class Key {
        int freq;
        char ch;

        Key(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    static class KeyComparator implements Comparator<Key> {

        @Override
        public int compare(Key o1, Key o2) {
            if (o1.freq < o2.freq)
                return 1;
            else if (o1.freq > o2.freq)
                return -1;
            else
                return 0;
        }
    }
}
