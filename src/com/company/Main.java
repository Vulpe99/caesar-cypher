package com.company;

public class Main {

    private static StringBuilder encode(String text, int shift){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            //cycle trough all the chars in our text
            char ch = text.toLowerCase().charAt(i);
            //check if it is a letter
            if (Character.isLetter(ch)) {
                if ((char) (ch + shift) > 122) {
                    char c = (char) (ch - (26 - shift));
                    sb.append(c);
                } else {
                    char c = (char) (ch + shift);
                    sb.append(c);
                }

            } else sb.append(ch);
        }
        return sb;
    }

    public static void main(String[] args) {
        String textToEncode = "Ana are zahar si Ion are mere!!";
        System.out.println(encode(textToEncode,10));
    }
}
