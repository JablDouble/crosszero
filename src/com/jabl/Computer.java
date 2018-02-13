package com.jabl;

public class Computer extends Thread {
    static char tableComp[][] = new char[3][3];

    @Override
    public void run() {
        synchronized (this) {
            while (Game.checkoutWin() & Game.getSteps() < 9) {
                if (!Game.isPlayerstep())
                    computerStep();
                }
            }
        }


    private static void computerStep(){
        tableComp = Game.getTable();
        int x = (int) (Math.random() * 3), y = (int) (Math.random() * 3);
        while (tableComp[x][y] == 'O' || tableComp[x][y] == 'X') {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        }
        Game.compGiveStep(x,y);
    }
}
