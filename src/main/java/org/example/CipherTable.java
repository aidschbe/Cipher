package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CipherTable {

    public CipherTable(List<String> charSet) {

        this.charSet = charSet;

        makeTable();
    }

    @Getter
    private List<String> charSet;

    @Getter
    private List<List<String>> table = new ArrayList<List<String>>();

    private void makeTable() {
        for (String letter : charSet) {
            int index = charSet.indexOf(letter);
            List<String> row = new ArrayList<>(charSet);
            Collections.rotate(row, -index);
            table.add(row);
        }
    }

    public void printTable() {
        for (List<String> row : table) {
            System.out.println(row);
        }
    }
}
