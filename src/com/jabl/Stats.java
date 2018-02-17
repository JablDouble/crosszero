package com.jabl;

import java.io.Serializable;

public class Stats implements Serializable{

    private int games;
    private int wins;
    private int fails;


    public void getStats(){
        System.out.println("Ваша статистика: \n" + "Всего игр сыграно: " + getGames()+"\n"
                            + "Побед: " + getWins() + " Поражений: "+ getFails());
    }

    public int getGames() {
        return games;
    }

    public void setGames() {
        games++;
    }

    public int getWins() {
        return wins;
    }

    public void setWins() {
        wins++;
    }

    public int getFails() {
        return fails;
    }

    public void setFails() {
        fails++;
    }

}
