package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int shift = 10;

        String textToEncode = "Ana are zahar si Ion are mere!!";

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < textToEncode.length(); i++) {
            //cycle trough all the chars in our text
            char ch = (char) textToEncode.toLowerCase().charAt(i);
            //check if it is a letter
                if (Character.isLetter(ch)) {
                        if ((char) (ch + shift) > 122) {
                            char c = (char) (ch -(26-shift));
                            sb.append(c);
                        } else {
                            char c = (char)(ch + shift);
                            sb.append(c);
                        }

                } else sb.append(ch);
        }

        //Print our new text
        System.out.print(sb);

    }
}
