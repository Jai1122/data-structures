package com.algo.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffMan {
    public static void main(String[] args) {

        String str = "geeksforgeeks";

        Coding coding = new Coding();
        Decoding decoding = new Decoding();

        HuffManResponse huffManResponse = coding.encode(str);
        String encodedString = getEncodedString(huffManResponse.codeMapping, str);
        System.out.println("Encoded String : " + encodedString);
        String decodedString = decoding.decode(huffManResponse.hNode, encodedString);
        System.out.println("Decoded String : " + decodedString);
    }

    private static String getEncodedString(Map<Character, String> codeMap, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(codeMap.get(str.charAt(i)));
        }

        return sb.toString();
    }

    private static Map<Character, Integer> prepareFrequencyMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {

            freqMap.put(str.charAt(i), freqMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        return freqMap;
    }
}

class HuffManNode {
    int data;
    char c;
    HuffManNode left, right;

    public HuffManNode(char c, int data) {
        this.c = c;
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class HuffManResponse {
    String str;
    HuffManNode hNode;
    Map<Character, String> codeMapping;

    public HuffManResponse(HuffManNode hNode, String str, Map<Character, String> codeMapping) {
        this.str = str;
        this.hNode = hNode;
        this.codeMapping = codeMapping;
    }
}

class Decoding {
    public String decode(HuffManNode root, String s) {
        StringBuilder sb = new StringBuilder();
        HuffManNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                curr = curr.left;
            } else {
                curr = curr.right;
            }

            if (curr.left == null && curr.right == null) {
                sb.append(curr.c);
                curr = root;
            }
        }
        return sb.toString();
    }
}

class Coding {

    Map<Character, String> codeMapping = new HashMap<>();

    public HuffManResponse encode(String str) {

        Map<Character, Integer> freqMap = prepareFrequencyMap(str);
        char[] charArray = new char[freqMap.size()];
        int[] freqArray = new int[freqMap.size()];

        int j = 0;
        for (Map.Entry<Character, Integer> keySet : freqMap.entrySet()) {
            charArray[j] = keySet.getKey();
            freqArray[j] = keySet.getValue();
            j++;
        }

        int n = charArray.length;
        PriorityQueue<HuffManNode> queue = new PriorityQueue<>(n, Comparator.comparingInt(o -> o.data));

        for (int i = 0; i < n; i++) {
            queue.add(new HuffManNode(charArray[i], freqArray[i]));
        }

        HuffManNode root = null;

        while (queue.size() > 1) {
            HuffManNode x = queue.poll();
            HuffManNode y = queue.poll();

            HuffManNode f = new HuffManNode('-', x.data + y.data);
            f.left = x;
            f.right = y;

            root = f;

            queue.add(f);
        }
        String encodedString = buildResponse(root, "", "");
        return new HuffManResponse(root, encodedString, codeMapping);
    }

    private Map<Character, Integer> prepareFrequencyMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {

            freqMap.put(str.charAt(i), freqMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        return freqMap;
    }


    private String buildResponse(HuffManNode root, String s, String encodedString) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            codeMapping.put(root.c, s);
            encodedString += s;
            return encodedString;
        }
        encodedString = buildResponse(root.left, s + "0", encodedString);
        encodedString = buildResponse(root.right, s + "1", encodedString);

        return encodedString;
    }
}
