package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> charSet = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));

        CipherTable table = new CipherTable(charSet);

        table.printTable();

        Cipher test = new Cipher(table);


        // System.out.println(test.makeKeyWord("att", "LEMON"));

        // String encTest = test.encode("attackatdawn", "LEMON");

        // String encTest2 = test.encode("klartext", "codersbay");

        String decTest = test.decode("FOVLRTUIFTGXTVJHEKCQKX", "codersbay");

        System.out.println(decTest);

        // String asdf = test.makeKeyWord("abcdefghiklm","ab");
    }
}