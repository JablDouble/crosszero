package com.jabl;

import java.io.*;

public class Game {
    private static char table[][] = new char[3][3];
    private static int cell = 49;
    private static boolean playerstep = true;


    public static void redact(int i) throws IOException, ClassNotFoundException {

        switch (i){
            case 1:
                if(playerstep)
                    table[0][0] = 'X';
                if(!playerstep)
                    table[0][0] = 'O';
                break;
            case 2:
                if(playerstep)
                    table[0][1] = 'X';
                if(!playerstep)
                    table[0][1] = 'O';
                break;
            case 3:
                if(playerstep)
                    table[0][2] = 'X';
                if(!playerstep)
                    table[0][2] = 'O';
                break;
            case 4:
                if(playerstep)
                    table[1][0] = 'X';
                if(!playerstep)
                    table[1][0] = 'O';
                break;
            case 5:
                if(playerstep)
                    table[1][1] = 'X';
                if(!playerstep)
                    table[1][1] = 'O';
                break;
            case 6:
                if(playerstep)
                    table[1][2] = 'X';
                if(!playerstep)
                    table[1][2] = 'O';
                break;
            case 7:
                if(playerstep)
                    table[2][0] = 'X';
                if(!playerstep)
                    table[2][0] = 'O';
                break;
            case 8:
                if(playerstep)
                    table[2][1] = 'X';
                if(!playerstep)
                    table[2][1] = 'O';
                break;
            case 9:
                if(playerstep)
                    table[2][2] = 'X';
                if(!playerstep)
                    table[2][2] = 'O';
                break;
        }

        drawTable();
        checkoutWin();
        steps++;
        if(checkoutWin())
            switchStep(isPlayerstep());
        if(!checkoutWin())
            win();
    }

    public static boolean checkoutWin(){
        for (int i = 0; i < 2; i++){
            if(table[i][0] == 'X' & table[i][1] == 'X' & table[i][2] == 'X' || table[i][0] == 'O' & table[i][1] == 'O' & table[i][2] == 'O') {
                return false;
            }
        }
        for (int i = 0; i < 2; i++){
            if(table[0][i] == 'X' & table[1][i] == 'X' & table[2][i] == 'X' || table[0][i] == 'O' & table[1][i] == 'O' & table[2][i] == 'O')
                return false;
        }

        if(table[0][0] == 'X' & table[1][1] == 'X' & table[2][2] == 'X' || table[0][2] == 'X' & table[1][1] == 'X' & table[2][0] == 'X')
            return false;

        if(table[0][0] == 'O' & table[1][1] == 'O' & table[2][2] == 'O' || table[0][2] == 'O' & table[1][1] == 'O' & table[2][0] == 'O')
            return false;

        return true;
    }

    public static void compGiveStep(int x, int y) throws IOException, ClassNotFoundException {
        table[x][y] = 'O';
        clearScreen();
        drawTable();
        steps++;
        if(checkoutWin())
            switchStep(isPlayerstep());
        if(!checkoutWin())
            win();
    }


    public static void win() throws IOException, ClassNotFoundException {
        System.out.println("Игра окончена!");
        File file = new File("C:\\Users\\Oleg Jablonsky\\IdeaProjects\\clone_crosszero\\stats.out");
        if(!file.exists())
            file.createNewFile();
        FileReader read = new FileReader(file);
        BufferedReader buffRead = new BufferedReader(read);
        Stats stats = new Stats();
        if(buffRead.readLine()!=null) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            stats = (Stats) objectInputStream.readObject();
        }
        if(isPlayerstep()) {
            System.out.println("Победитель: Player!");
            stats.setWins();
        }
        if(!isPlayerstep()) {
            System.out.println("Победитель: Computer!");
            stats.setFails();
        }
        stats.setGames();
        stats.getStats();
      FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Oleg Jablonsky\\IdeaProjects\\clone_crosszero\\stats.out");
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(stats);
      objectOutputStream.close();
    }

    public static void switchStep(boolean playerstep) {
        int b = 0;
        if (playerstep)
            b = 1;
        if (!playerstep)
            b = 2;

        switch (b) {
            case 1:
                setPlayerstep(false);
                break;
            case 2:
                setPlayerstep(true);
                break;
        }

        if (steps < 9) {
            if (!isPlayerstep())
                System.out.println("Сейчас ходит: Computer");
            if (isPlayerstep())
                System.out.println("Сейчас ходит: Player");
        }
    }


    public static void drawTable(){
        System.out.println("     "+"   |   "+"    "+"|   ");
        System.out.println("    " + table[0][0]+"   |   "+table[0][1]+"   |   "+table[0][2]);
        System.out.println("--------+-------+----------");
        System.out.println("    " + table[1][0]+"   |   "+table[1][1]+"   |   "+table[1][2]);
        System.out.println("--------+-------+----------");
        System.out.println("    " + table[2][0]+"   |   "+table[2][1]+"   |   "+table[2][2]);
        System.out.println("     "+"   |   "+"    "+"|   ");
    }


    public static void clearScreen(){
        for(int i = 0; i < 30; i++)
            System.out.println();
    }

    public Game(){
        setSteps(0);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                table[i][j] = getCell();
                cell++;
            }
        }
        drawTable();
    }


    public static int getSteps() {
        return steps;
    }

    public static void setSteps(int steps) {
        Game.steps = steps;
    }

    private static int steps;

    public static boolean isPlayerstep() {
        return playerstep;
    }

    public static void setPlayerstep(boolean playerstep) {
        Game.playerstep = playerstep;
    }

    public static char getCell() {
        return (char) cell;
    }

    public static void setCell(int cell) {
        Game.cell = cell;
    }

    public static char[][] getTable() {
        return table;
    }

    public void setTable(char[][] table) {
        Game.table = table;
    }


}