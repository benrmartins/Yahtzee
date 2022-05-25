import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Game Yahtzee");
        System.out.println("The objective of the game is to score points by rolling five dice to make certain combinations. ");
        System.out.println("Ones – count only the dice with a 1 (add the 1’s to get a score)");
        System.out.println("Twos – count only the dice with a 2 (add the 2’s to get a score)");
        System.out.println("Threes – count only the dice with a 3 (add the 3’s to get a score)");
        System.out.println("Fours – count only the dice with a 4 (add the 4’s to get a score)");
        System.out.println("Fives – count only the dice with a 5 (add the 5’s to get a score)");
        System.out.println("Sixes – count only the dice with a 6 (add the 6’s to get a score)");
        System.out.println("3 of a kind (if there are 3 dice with the same number, add the dice)");
        System.out.println("4 of a kind (if there are 4 dice with the same number, add the dice)");
        System.out.println("Full house – 3 dice with one number, 2 dice with different number (25pt)");
        System.out.println("Small straight – the dice have 4 numbers in a row (ex. 1, 2, 3, 4 or 2, 3, 4, 5 or 3, 4, 5, 6) (30 pts)");
        System.out.println("Large straight – dice have 5 numbers in a row (1, 2, 3, 4, 5 or 2, 3, 4, 5, 6)(40 pts)");
        System.out.println("Yahtzee-all five dice have the same number (50 pts)");
        System.out.println("Chance-add all dice (used when nothing else seems to fit)");

        System.out.println("Note: -1 means that you have not picked the category also you can only pick a category once per game.");
        System.out.println("");

        ArrayList<Integer> chosen = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);


        System.out.print("Press enter to play");
        String name = scanner.nextLine();

        Dice roll = new Dice();

        for(int i = 0; i < 13; i++) {
            boolean bools = true;
            int count = 0;
            roll.rollDice();
            while(bools) {
                System.out.println("Dice rolled: " + roll.displayDice());
                System.out.print("Do you want to roll again y/n ");
                String yesNo = input.nextLine();
                count++;
                if(yesNo.equals("y")) {
                    if(count > 2) {
                        System.out.println("You can only roll three times.");
                        break;
                    } else {
                        boolean bool = true;
                        do {
                            System.out.print("Choose the dice number to roll (1-5), type -1 to start rolling ");
                            int index = scan.nextInt();

                            if(index == -1) {
                                bool = false;
                                break;
                            }
                            if(index < 6) {
                                chosen.add(index -1);
                            } else {
                                System.out.println("number not in range");
                            }

                        } while(bool);

                        roll.rollAgain(chosen);
                        chosen.clear();

                    }

                } else {
                    bools = false;
                }
            }
            try {
                System.out.println("Dice rolled: " + roll.displayDice());
                roll.displayCard();
                System.out.print("Choose Your category or select 0 to quit ");
                int category = scanner.nextInt();
                roll.checkCategory(category);
                roll.displayCard();

                if(category == 0) {
                    roll.displayCard();
                    System.out.println("Thanks for playing! ");
                    break;
                }

            } catch(Exception e) {
                System.out.println("not valid input");
            }
        }
    }
}