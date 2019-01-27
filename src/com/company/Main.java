package com.company;

public class Main {

    private static StringBuilder encode(String text) {
        //creating string builder
        StringBuilder sb = new StringBuilder();
        int shift = Integer.parseInt(String.valueOf(text.charAt(0)));
        for (int i = 0; i < text.length(); i++) {
            //cycle trough all the chars in our text
            char ch = text.toLowerCase().charAt(i);
            //check if it is a letter
            if (Character.isLetter(ch)) {
                //if with shift it's greater than 122(z), we must go from the beginning of the interval (97-122)
                if ((char) (ch + shift) > 122) {
                    //the diff that exceeds 122 must be added to 97.
                    char c = (char) (ch - (26 - shift));
                    //add it to our string
                    sb.append(c);
                } else {
                    //add the shift
                    char c = (char) (ch + shift);
                    //add it to our string
                    sb.append(c);
                }
                //if it's not a letter, add it like this to our string
            } else sb.append(ch);
        }
        return sb;
    }

    private static StringBuilder decode(String text) {
        //creating string builder
        StringBuilder sb = new StringBuilder();
        int shift = Integer.parseInt(String.valueOf(text.charAt(0)));
        //making the text lowercase
        String lowerText = text.toLowerCase();
        //cycle trough every char in the text
        for (int i = 0; i < text.length(); i++) {
            //break the text in single chars low-case
            char ch = lowerText.charAt(i);
            //check if it is a letter
            if (Character.isLetter(ch)) {
                //see what looks like if you subtract the shift
                char c = (char)(ch-shift);
                //if after that it looks smaller than 'a', subtract from 'z'
                if (c < 97) {
                    char cSmall = (char)(122-(96-c));
                    sb.append(cSmall);
                    //if it's not smaller than 'a', just put it in our new text
                } else sb.append(c);

                //if it's not a letter, put it like that.
            } else sb.append(ch);
        }

        return sb;
    }

    public static void main(String[] args) {
        String textToEncode = "3Ana are zahar si Ion are mere si quartz!!";
        System.out.println(textToEncode);
        System.out.println("Encoding the text");
        String encodedText = encode(textToEncode).toString();
        System.out.println(encodedText);
        System.out.println("Decoding the text");
        String decodedText = decode(encodedText).toString();
        System.out.println(decodedText);
    }
}
