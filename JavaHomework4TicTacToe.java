/**
 * Java 1. Homework 4
 * @author Oleg
 * @version 27.01.21
 */
import java.util.Random;
import java.util.Scanner;

class JavaHomework4TicTacToe {
    Final char CHAR_0 = '0';
    Final char CHAR_X = 'x';
    Final char CHAR_empty = '.';
    Final char CHAR_win = "You won!";
    Final char CHAR_Draw = "Sorry, Draw...!";
    Final char CHAR_lose = "You lose!";
    Final char CHAR_gameOver = "Game over";
    Final char CHAR_input = "Enter x y [1..3]: ";
    Random random;
    Scanner scanner;
    char[][] table;

    public static void main(String[] args) {
        new TicTacToe().game();
    }
    TicTacToe() { //constructor
        table = new char[3][3];
        random = new Random();
        scanner = new Scanner(System.in);
    }
    void game(){ //logical
        initTable();
        printTable();
        while(true) {
            turnHuman();
            if (checkWin(CHAR_0)) {
                System.out.println(CHAR_win);
                break;
            }
            if (isTableFull(CHAR_X)) {
                System.out.println(CHAR_Draw);
                break;
            }
            turnAI();
            printTable();
            if (checkWin(CHAR_0)) {
                System.out.println(CHAR_lose);
                break;
            }
            if (isTableFull(CHAR_X)) {
                System.out.println(CHAR_Draw);
                break;
            }
        }
        System.out.println(CHAR_gameOver);
        printTable();
    }
    void initTable() { 
        for (int x=0; x<3; x++) {
            for (int y=0; y<3; y++)
                table[x][y] = '.';
            }
        }
    }
    void printTable() { 
        for (int y=0; y<3; y++) {
            for (int x=0; x<3; x++)
                System.out.print(table[x][y] + " ");
            }
            System.out.println();
        }
    }
    void turnHuman() { 
        int x, y;
        do {
            System.out.print(CHAR_input);
            x=scanner.nextInt () - 1;
            y=scanner.nextInt () - 1;
        } while (!isCallValid(x, y));
        table[x][y] = CHAR_X;
    }
    void turnAI() { 
        int x, y;
        do {
            x=random.nextInt(3);
            y=random.nextInt(3);
        } while (!isCallValid(x, y));
        table[x][y] = CHAR_0;
    }
    boolean isCallValid(int x, int y) { 
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            
        }
        return table[x][y] == CHAR_empty;
    }
    boolean checkWin(char ch) { 
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == ch && table[i][1] == ch && table[i][2] == ch) || (table[0][i] == ch && table[1][i] == ch && table[2][i] == ch)) return true;
                if ((table[0][0] == ch && table[1][1] == ch && table[2][2] == ch) || (table[2][0] == ch && table[1][1] == ch && table[0][2] == ch)) return true;
        return false;
    }
    boolean isTableFull() { 
        for (int x=0; x<3; x++) {
            for (int y=0; y<3; y++)
                if (table[x][y] == CHAR_empty) {
                    return false;
                }
            }
        }
        return true;
    }
}