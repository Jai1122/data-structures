package com.ds.strings;

import java.util.Locale;

public class MyString {

    private static String stringCopyIterative(String source, String destn){
        if(destn.length() != source.length()){
            throw new IllegalArgumentException("Destination string cannot be smaller than source string");
        }
        char[] sourceChar = source.toCharArray();
        char[] destnChar  = destn.toCharArray();
        int i;
        for (i = 0; i < sourceChar.length;i++) {
            destnChar[i]    =   sourceChar[i];
        }
        return String.valueOf(destnChar);
    }

    private static String stringCopyRecursive(char[] sourceChar, char[] destnChar, int index){
        if(sourceChar.length != destnChar.length) throw new IllegalArgumentException("Wrong args");
        if(index == destnChar.length) return String.valueOf(destnChar);
        destnChar[index]    =   sourceChar[index];
        return stringCopyRecursive(sourceChar,destnChar,index+1);
    }

    private static boolean isPanagram(String str){
        str = str.toLowerCase();
        boolean[] chars =   new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') continue;
            chars[str.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < chars.length; i++) {
            if(!chars[i]) return false;
        }

        return true;
    }

    private static void missingCharsForPanagram(String str){
        str = str.toLowerCase();
        boolean chars[] = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') continue;
            chars[str.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < chars.length; i++) {
            if(!chars[i]) System.out.println((char)('a'+ i));
        }
    }

    private static void checkPangrammaticLipogram(String str){
        str = str.toLowerCase();
        boolean chars[] = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            if(!(str.charAt(i) == ' ')){
                chars[str.charAt(i) - 'a'] = true;
            }
        }

        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            if(!chars[i]) count++;
        }
        if(count == 0){
            System.out.println("Pangram");
        }else if(count == 1){
            System.out.println("PangrammaticLipogram");
        }else {
            System.out.println("Lipogram");
        }
    }

    private static void removePunctuations(String str){
        char[] chars = new char[str.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j =0 ; i < str.length(); i++) {
            char c = str.charAt(i);
            if((c >= 'A' && c<='Z') || (c >= 'a' && c <= 'z') || (c  == ' ')){
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }

    private static void stringOrInteger(String str){
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))){
                System.out.println("String ");
                return;
            }
        }
        System.out.println("Integer");
    }

    public static void main(String[] args) {
        //System.out.println(stringCopyIterative("Hello", "World"));
        //System.out.println(stringCopyRecursive("Hello".toCharArray(),"World".toCharArray(),0));
        //System.out.println(isPanagram("The quick brown fox jumps over the lazy dog"));
        //missingCharsForPanagram("The quick brown fox jumps over the dog");
        //checkPangrammaticLipogram("The quick brown fox jump over the lazy dog");
        //removePunctuations("Hello!!!, he said ---and went.");
        stringOrInteger("123.4");
    }
}
