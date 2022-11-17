package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] symbols = new char[9];

//        symbols = inputSymbols(symbols, scanner); //Input symbols

        boolean isGameOver = false;
        String msg = "";
        char lastChar = ' ';
        printSymbolsOnScreen(symbols); //Output symbols on Screen

        do {
            lastChar = promptUserInput(symbols, scanner, lastChar); //Prompt the user to make a move

            char winner = checkWinner(symbols); //Verify if there is a winner

            //Verify is Draw if not win
            boolean isDraw = false;
            if (winner == 'F')
                isDraw = checkIsDraw(symbols);

            //Verify if is Impossible
            boolean isImpossible = false;
            if (!isDraw)
                isImpossible = checkIsImpossible(symbols);

            msg = winner == 'X' || winner == '0' || winner == 'O' ? winner + " wins" :
                    winner == 'I' ? "Impossible" :
                            isDraw ? "Draw" :
                                    isImpossible ? "Impossible" : "Game not finished";

            isGameOver = msg == "Game not finished" ? false : true;
        } while (!isGameOver);

        System.out.println(msg);
    }

    /*public static char[] inputSymbols(char[] symbols, Scanner scanner) {
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X' || input.charAt(i) == '0' || input.charAt(i) == 'O' ) {
                symbols[i] = input.charAt(i);
            } else {
                symbols[i] = '_';
            }
        }

        return symbols;
    }*/

    public static void printSymbolsOnScreen(char[] symbols) {
        int LINES = 3;
        int count = 0;

        System.out.println("---------");
        for (int i = 0; i < LINES; i++) {
            char symbol1 = symbols[count] == 'X' ? 'X' : symbols[count] == 'O' ? 'O' : symbols[count] == '0' ? '0' : '_';
            char symbol2 = symbols[count + 1] == 'X' ? 'X' : symbols[count + 1] == '0' ? '0' : symbols[count + 1] == 'O' ? 'O' : '_';
            char symbol3 = symbols[count + 2] == 'X' ? 'X' : symbols[count + 2] == '0' ? '0' : symbols[count + 2] == 'O' ? 'O' : '_';

            System.out.print("| " + symbol1 + " ");
            System.out.print(symbol2 + " ");
            System.out.print(symbol3 + " |");
            System.out.println("");
            count += 3;
        }
        System.out.println("---------");
    }

    public static char promptUserInput(char[] symbols, Scanner scanner, char lastChar) {

        boolean inputIsCorrect = false;

        do {
            int[] position = new int[2];

            try {
                System.out.println("*** Input position ***");
                String posicion = scanner.next();

                position[0] = Integer.parseInt(posicion);
                if (scanner.hasNext()) {
                    position[1] = Integer.parseInt(scanner.next());
                }

                if (position[0] > 3 || position[1] > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {

                    int v = position[0];
                    int h = position[1];

                    int indexPos = (v == 1 && h > 0 && h < 4) || (v > 1 && v < 4 && h == 3) ? v * h :
                                v > 1 && v < 4 && h == 2 ? v * h + (v - 1) :
                                v * h + (sumatorial(v-1) + h);


                    if (symbols[indexPos-1] == 'X' || symbols[indexPos-1] == 'O' || symbols[indexPos-1] == '0') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        symbols[indexPos-1] = lastChar == ' ' || lastChar == 'O' || lastChar == '0' ? 'X' : 'O';

                        lastChar = symbols[indexPos-1];

                        printSymbolsOnScreen(symbols);
                        inputIsCorrect = true;
                    }
                }
            }
            catch(InputMismatchException e) { //InputMismatchException
                System.out.println("You should enter numbers!");
                scanner.next();
            }
        } while (!inputIsCorrect);

        return lastChar;
    }

    public static char checkWinner(char[] symbols) {

        int[][][] waysOfWin = {
                {{0,1,2}, {3,4,5}, {6,7,8}}, //Horizontals
                {{0,3,6}, {1,4,7}, {2,5,8}}, //Verticals
                {{0,4,8}, {2,4,6}} //Diagonals
        };
        char winner = 'F';
        char lastWinner = 'F';
        int countWinners = 0;

        for (int[][] items: waysOfWin) {
            for (int[] items2: items) {

                winner = symbols[items2[0]] == 'X' && symbols[items2[1]] == 'X' && symbols[items2[2]] == 'X' ? 'X' :
                        symbols[items2[0]] == '0' && symbols[items2[1]] == '0' && symbols[items2[2]] == '0' ? '0' :
                        symbols[items2[0]] == 'O' && symbols[items2[1]] == 'O' && symbols[items2[2]] == 'O' ? 'O' :'F';

                if (winner == 'X' || winner == '0' || winner == 'O') {
                    lastWinner = winner;
                    countWinners++;
                }
            }
        }
        return countWinners > 1 ? 'I' : lastWinner;
    }

    public static  boolean checkIsDraw(char[] symbols) {

        boolean isDraw = false;

        for (int item: symbols) {
            isDraw = item == 'X' || item == '0' || item == 'O';

            if (!isDraw)
                return isDraw;
        }

        return isDraw;
    }

    public static boolean checkIsImpossible(char[] symbols) {
        int countX = 0;
        int count0 = 0;

        for (int item: symbols) {
            if (item == '0' || item == 'O')
                count0++;
            if (item == 'X')
                countX++;
        }
        return countX - count0  >= 2 || count0 - countX  >= 2;
    }

    static int sumatorial(int number) {

        if (number == 0)
            return 0;

        return number - 1 + number;
    };
}
