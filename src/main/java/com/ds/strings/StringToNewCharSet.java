package com.ds.strings;

public class StringToNewCharSet {

    public static void main(String[] args) {
        String charset = "qwertyuiopasdfghjklzxcvbnm";
        String input = "utta";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            System.out.print((char) ('a' + charset.indexOf(input.charAt(i))));
        }
    }
}
