package com.jabl;

import java.io.IOException;

public class Computer extends Thread {
    static char tableComp[][] = new char[3][3];

    @Override
    public void run() {
        synchronized (this) {
            while (Game.checkoutWin() & Game.getSteps() < 9) {
                if (!Game.isPlayerstep())
                    try {
                        computerStep();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
            }
            }
        }


    private static void computerStep() throws IOException, ClassNotFoundException {
        tableComp = Game.getTable();
        int x = (int) (Math.random() * 3), y = (int) (Math.random() * 3);
        while (tableComp[x][y] == 'O' || tableComp[x][y] == 'X') {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        }
        Game.compGiveStep(x,y);
    }
}
