package org.example;

import java.util.*;

public class Cipher {

    public Cipher(CipherTable table){

        this.table = table;
    }

    CipherTable table;

    private String makeKeyWord(String message, String keyword) {

        if (message.length() > keyword.length()) {
            int difference = message.length() - keyword.length();

            for (int i = 0; i < difference; i++) {

                keyword += keyword.charAt(i);
            }
            return keyword;
        }

        if (message.length() < keyword.length()) {

            keyword = keyword.substring(0, message.length());

            return keyword;

        }

        return keyword;
    }

    public String encode(String message, String keyword) {

        message = message.toUpperCase();
        keyword = keyword.toUpperCase();
        keyword = makeKeyWord(message, keyword);

        String result = "";

        for (int i = 0; i < message.length(); i++) {
            char mLetter = message.charAt(i);
            char kLetter = keyword.charAt(i);
            int row = this.table.getCharSet().indexOf(String.valueOf(mLetter));
            int col = this.table.getCharSet().indexOf(String.valueOf(kLetter));

            String temp = this.table.getTable().get(row).get(col);

            result += temp;

        }

        return result;
    }

    private String getRow(char letter, int col){

        for (List row : this.table.getTable()) {

            if (row.get(col).equals(String.valueOf(letter))){
                int index = this.table.getTable().indexOf(row);
                return this.table.getCharSet().get(index);
            }
        }
        return null;
    }

    public String decode(String message, String keyword) {

        message = message.toUpperCase();
        keyword = keyword.toUpperCase();
        keyword = makeKeyWord(message, keyword);

        String result = "";

        for (int i = 0; i < message.length(); i++) {
            char mLetter = message.charAt(i);
            char kLetter = keyword.charAt(i);

            int col = this.table.getCharSet().indexOf(String.valueOf(kLetter));

            String temp = getRow(mLetter, col);

            result += temp;
        }
        return result;
    }
}