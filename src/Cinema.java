
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    public static void ocupiedSeats(char[][] b, int row, int seat) {
        b[row - 1][seat] = 'B';
    }


    public static void statistics(char[][] a, int tickets10$, int tickets8$, int rows, int seats) {
        int nrTickets = tickets8$ + tickets10$;
        System.out.printf("Number of purchased tickets: %d", nrTickets);
        System.out.println();
        double percentage = ((double) nrTickets * 100) / ((double) rows * (double) seats);
        System.out.printf("Percentage: %.2f", percentage);
        System.out.print("%");
        System.out.println();
        int currentIncome = 10 * tickets10$ + 8 * tickets8$;
        System.out.printf("Current income: $%d", currentIncome);
        System.out.println();
        int c = rows / 2;
        int totalIncome = 0;
        if (rows * seats <= 60) {
            totalIncome = rows * seats * 10;
            System.out.printf("Total income: $%d", totalIncome);
        } else {
            totalIncome = c * seats * 10 + (rows - c) * seats * 8;
            System.out.printf("Total income: $%d", totalIncome);
        }
        System.out.println();
    }

    public static void fillArr(char[][] arr) {
        for (char[] chars : arr) {
            Arrays.fill(chars, 'S');
        }
    }

    public static void option() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void printCinema(char[][] arr) {
        System.out.println("Cinema:");
        for (int i = 0; i < 1; i++) {
            System.out.print(" ");
            for (int j = 0; j < arr[i].length - 1; j++) {
                System.out.print(" " + (j + 1));
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + 1);
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = 'S';
                System.out.print(' ');
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void printOcupiedSeats(char[][] arr) {
        System.out.println("Cinema:");
        for (int i = 0; i < 1; i++) {
            System.out.print(" ");
            for (int j = 0; j < arr[i].length - 1; j++) {
                System.out.print(" " + (j + 1));
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + 1);
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(' ');
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter the number of rows:");
        int a = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int b = scanner.nextInt();

        char[][] arr = new char[a][b + 1];

        fillArr(arr);

        int counter = 0;
        boolean exit = false;
        int count10$ = 0;
        int count8$ = 0;

        while (true) {

            option();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    if (counter == 0) {
                        printCinema(arr);
                    } else {
                        printOcupiedSeats(arr);
                    }
                    break;
                case 2:
                    int d = 0;
                    int e = 0;
                    while (true) {
                        System.out.println();
                        System.out.println("Enter a row number:");
                        d = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        e = scanner.nextInt();
                        if (d > a || d < 1 || e > b || e < 1) {
                            System.out.println("Wrong input!");

                        } else if (arr[d - 1][e] == 'B') {
                            System.out.println("That ticket has already been purchased!");
                        } else {
                            break;
                        }
                    }

                    double c = a / 2;

                    ocupiedSeats(arr, d, e);
                    if (d <= c || a * b <= 60) {
                        int price1 = 10;
                        System.out.printf("Ticket price: $%d", price1);
                        System.out.println();
                        System.out.println();
                        count10$++;
                    } else {
                        int price2 = 8;
                        System.out.printf("Ticket price: $%d", price2);
                        System.out.println();
                        System.out.println();
                        count8$++;
                    }
                    counter++;

                    break;
                case 3:
                    statistics(arr, count10$, count8$, a, b);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong");
                    break;
            }
            if (exit) {
                break;
            }
        }
    }
}