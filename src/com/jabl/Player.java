package com.jabl;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends Thread {
    @Override
    public void run() {
        synchronized (this) {
            while (Game.checkoutWin() & Game.getSteps() < 9) {
                //if(Game.isPlayerstep()) {
                    int step = 0;
                    while(step < 1 || step > 9) {
                        Scanner scanner = new Scanner(System.in);
                        try {
                            step = scanner.nextInt();
                        } catch (InputMismatchException e){
                            System.out.println("Нужно вводить цифры, а не символы!");
                        }
                        if(step < 1 || step > 9)
                            System.out.println("Неправильный ввод! Вводите символы от 1 до 9");
                    }
                    if(checkStep(step)) {
                        Game.clearScreen();
                        try {
                            Game.redact(step);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("Нельзя вводить клетки, где стоит уже крестик или нолик");
                    }
                    if(Game.getSteps() == 9 && Game.checkoutWin()) {
                        System.out.println("Ничья!");

                        }
                    }
            }
        }

        public static boolean checkStep(int step){
        boolean answer = false;
            for(int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if(Game.getTable()[i][j] == (char)step+48)
                        answer = true;
                }
            }
            return answer;
        }
    }

