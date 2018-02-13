package com.jabl;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        new Game();
        new Player().start();
        new Computer().start();
    }
}


