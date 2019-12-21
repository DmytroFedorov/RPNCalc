package com.test;

import java.io.InputStream;
import java.util.Scanner;

public class DataSource {

    private final Scanner in;

    public DataSource(InputStream inputStream) {
        in = new Scanner(inputStream);
    }

    public String getInput() {
        return in.nextLine().trim();
    }


}
