import java.util.Scanner;

public class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;
    static boolean backToMain = false;
    static boolean exit = true;


    public static void coffeeEstimation(int water, int milk, int coffeeBeans, int coffeeCups) {
        int waterForCups = water / 200;
        int milkForCups = milk / 50;
        int coffeeForCups = coffeeBeans / 15;
        int smallerValue = 0;
        // se poate folosi Math.min();

        int[] arr = {waterForCups, milkForCups, coffeeForCups};
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] <= arr[i]) {
                smallerValue = arr[i - 1];
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] <= smallerValue) {
                        smallerValue = arr[j];
                    }
                }
            }

        }

        if (smallerValue < coffeeCups) {
            System.out.printf("No, I can make only %d cup(s) of coffee", smallerValue);
        } else if (smallerValue == coffeeCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", smallerValue - coffeeCups);
        }
    }

    public void buy(boolean backToMain, String choice, int water, int milk, int coffeeBeans, int cups,
                    int money) {
        backToMain = false;
        if (choice.equals("back")) {
            backToMain = true;
        } else {
            switch (choice) {
                case "1":
                    if (water >= 250 && coffeeBeans >= 16 && cups >= 1) {
                        CoffeeMachine.water -= 250;
                        CoffeeMachine.coffeeBeans -= 16;
                        CoffeeMachine.cups -= 1;
                        CoffeeMachine.money += 4;
                        System.out.println("I have enough resources, making you a coffee!\n");
                    } else {
                        String lowWater = water < 250 ? "water" : "";
                        String lowCoffeeBeans = coffeeBeans < 16 ? "coffeeBeans" : "";
                        String lowCups = cups < 1 ? "disposable cups" : "";
                        System.out.printf("Sorry, not enough %s%s%s!\n", lowWater, lowCoffeeBeans, lowCups);
                    }
                    break;
                case "2":
                    if (water >= 350 && coffeeBeans >= 20 && cups >= 1 && milk >= 75) {
                        CoffeeMachine.water -= 350;
                        CoffeeMachine.milk -= 75;
                        CoffeeMachine.coffeeBeans -= 20;
                        CoffeeMachine.cups -= 1;
                        CoffeeMachine.money += 7;
                        System.out.println("I have enough resources, making you a coffee!\n");
                    } else {
                        String lowWater = water < 350 ? "water" : "";
                        String lowCoffeeBeans = coffeeBeans < 20 ? "coffeeBeans" : "";
                        String lowCups = cups < 1 ? "disposable cups" : "";
                        String lowMilk = milk < 75 ? "milk" : "";
                        System.out.printf("Sorry, not enough %s%s%s%s!\n", lowWater, lowCoffeeBeans, lowCups, lowMilk);
                    }
                    break;
                case "3":
                    if (water >= 200 && coffeeBeans >= 12 && cups >= 1 && milk >= 100) {
                        CoffeeMachine.water -= 200;
                        CoffeeMachine.milk -= 100;
                        CoffeeMachine.coffeeBeans -= 12;
                        CoffeeMachine.cups -= 1;
                        CoffeeMachine.money += 6;
                        System.out.println("I have enough resources, making you a coffee!\n");
                    } else {
                        String lowWater = water < 200 ? "water" : "";
                        String lowCoffeeBeans = coffeeBeans < 12 ? "coffeeBeans" : "";
                        String lowCups = cups < 1 ? "disposable cups" : "";
                        String lowMilk = milk < 100 ? "milk" : "";
                        System.out.printf("Sorry, not enough %s%s%s%s!\n", lowWater, lowCoffeeBeans, lowCups, lowMilk);
                    }
                    break;
            }
        }
    }

    public void fill(int water, int milk, int coffeeBeans, int cups, int money) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        CoffeeMachine.water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        CoffeeMachine.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        CoffeeMachine.coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        CoffeeMachine.cups += scanner.nextInt();
        System.out.println();
        //initialPrint(water, milk, coffeeBeans, cups, money);

    }

    public void take(int money) {
        System.out.printf("I gave you %d\n\n", money);
        CoffeeMachine.money = 0;
        //initialPrint(water, milk, coffeeBeans, cups, money);
    }

    //    PENTRU UPDATE VARIABILE IN METODE FOLOSESTE "  THIS.variabila "!!!!
    public static void initialPrint(int water, int milk, int coffeeBeans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", coffeeBeans);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n\n", money);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (exit) {

            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String option = scanner.next();
            System.out.println();
            switch (option) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String choice = scanner.next();
                    coffeeMachine.buy(backToMain, choice, water, milk, coffeeBeans, cups, money);

                    if (backToMain) {

                        continue;
                    }

                    break;
                case "fill":
                    coffeeMachine.fill(water, milk, coffeeBeans, cups, money);
                    break;
                case "take":
                    coffeeMachine.take(money);
                    break;
                case "remaining":
                    initialPrint(water, milk, coffeeBeans, cups, money);
                    break;
                case "exit":
                    exit = false;
                    break;
            }
        }
    }
}
