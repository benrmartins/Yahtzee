import java.util.ArrayList;
import java.util.Arrays;

public class Dice {
    private int totalScore = 0;
    private int[] diceArray = new int[5];
    private String name;
    private int ones = -1;
    private int twos = -1;
    private int threes = -1;
    private int fours = -1;
    private int fives = -1;
    private int sixes = -1;
    private int threeOfKind = -1;
    private int fourOfKind = -1;
    private int fullHouse = -1;
    private int smallStraight = -1;
    private int largeStraight = -1;
    private int Yahteez = -1;
    private int chanceAdd = -1;

    public void rollDice() {
        int random = 0;
        for(int i = 0; i < diceArray.length; i++) {
            random = (int) (Math.random() * 6) + 1;
            diceArray[i] = random;
        }
    }

    public void rollAgain(ArrayList<Integer> chosen) {
        for(int i = 0; i < chosen.size(); i++) {
            diceArray[chosen.get(i)] = (int) (Math.random() * 6) + 1;
        }

    }

    public String displayDice() {
        String roll = "";
        for(int i = 0; i < diceArray.length; i++) {
            roll += "\nDie " + (i+1) +": " + diceArray[i] + " ";
        }
        return roll;
    }


    public void displayCard() {
        System.out.println("");
        System.out.println("Category             Score: " + totalScore);
        System.out.println("1-Ones:                " + ones);
        System.out.println("2-Twos:                " + twos);
        System.out.println("3-Threes:              " + threes);
        System.out.println("4-Fours:               " + fours);
        System.out.println("5-Fives:               " + fives);
        System.out.println("6-Sixes:               " + sixes);
        System.out.println("7-Three of a kind:     " + threeOfKind);
        System.out.println("8-Four of a kind:      " + fourOfKind);
        System.out.println("9-Full House:          " + fullHouse);
        System.out.println("10-Small Straight:     " + smallStraight);
        System.out.println("11-Large Straight:     " + largeStraight);
        System.out.println("12-Yahteez:            " + Yahteez);
        System.out.println("13-Chance-add:         " + chanceAdd);
    }

    public void checkCategory(int n) {
        switch(n) {
            case 1:
                upperOnes();
                break;
            case 2:
                upperTwos();
                break;
            case 3:
                upperThrees();
                break;
            case 4:
                upperFours();
                break;
            case 5:
                upperFives();
                break;
            case 6:
                upperSix();
                break;
            case 7:
                checkThreeKind();
                break;
            case 8:
                checkFourKind();
                break;
            case 9:
                checkFullHouse();
                break;
            case 10:
                checkSmallStraight();
                break;
            case 11:
                checkLargeStraight();
                break;
            case 12:
                checkYahtzee();
                break;
            case 13:
                checkChanceAdd();
                break;
        }
    }

    public void upperOnes() {
        if(ones == -1 || ones == 0) {
            int count = 0;
            for(int i = 0; i < 5; i++) {
                if(diceArray[i] == 1) {
                    count += 1;
                }
            }
            ones = count;
            totalScore += ones;
        } else {
            System.out.println("You already played this category");
        }

    }

    public void upperTwos() {
        if(twos == -1 || twos == 0) {
            int count = 0;
            for(int i = 0; i < 5; i++) {
                if(diceArray[i] == 2) {
                    count += 2;
                }
            }
            twos = count;
            totalScore += twos;
        } else {
            System.out.println("You already played this category");
        }

    }

    public void upperThrees() {
        if(threes == -1 || threes == 0) {
            int count = 0 ;
            for(int i = 0; i < 5; i++) {
                if(diceArray[i] == 3) {
                    count += 3;
                }
            }
            threes = count;
            totalScore += threes;
        } else {
            System.out.println("You already played this category");
        }

    }

    public void upperFours() {
        if(fours == -1 || fours == 0) {
            int count = 0 ;
            for(int i = 0; i < 5; i++) {
                if(diceArray[i] == 4) {
                    count += 4;
                }
            }
            fours = count;
            totalScore += fours;
        } else {
            System.out.println("You already played this category");
        }
    }

    public void upperFives() {
        if(fives == -1 || fives == 0) {
            int count = 0 ;
            for(int i = 0; i < 5; i++) {
                if(diceArray[i] == 5) {
                    count += 5;
                }
            }
            fives = count;
            totalScore += fives;
        } else {
            System.out.println("You already played this category");
        }
    }

    public void upperSix() {
        if(sixes == -1 || sixes == 0) {
            int count = 0 ;
            for(int i = 0; i < 5; i++) {
                if(diceArray[i] == 6) {
                    count += 6;
                }
            }
            sixes = count;
            totalScore += sixes;
        } else {
            System.out.println("You already played this category");

        }

    }

    public void checkThreeKind() {
        boolean bool = false;
        if(threeOfKind == -1 || threeOfKind == 0) {
            int count = 0;
            for(int i = 0; i < 5; i++) {
                count = 0;
                if(bool) {
                    break;
                }
                for(int j = 0; j < 5; j++) {
                    if(diceArray[i] == diceArray[j]) {
                        count++;
                        if(count >= 3){
                            count = diceArray[i] * 3;
                            bool = true;
                            break;
                        }
                    }
                }
                if(count < 3) {
                    threeOfKind = 0;
                } else {
                    threeOfKind = count;
                }
            }
            totalScore += threeOfKind;
        } else {
            System.out.println("You already played this category");
        }

    }

    public void checkFourKind() {
        boolean bool = false;
        if(threeOfKind == -1 || threeOfKind == 0) {
            int count = 0;
            for(int i = 0; i < 5; i++) {
                count = 0;
                if(bool) {
                    break;
                }
                for(int j = 0; j < 5; j++) {
                    if(diceArray[i] == diceArray[j]) {
                        count++;
                        if(count >= 4){
                            count = diceArray[i] * 4;
                            bool = true;
                            break;
                        }
                    }
                }
                if(count < 4) {
                    fourOfKind = 0;
                } else {
                    fourOfKind = count;
                }
            }
            totalScore += fourOfKind;
        } else {
            System.out.println("You already played this category");
        }

    }

    public void checkYahtzee() {
        if(Yahteez == -1 || Yahteez == 0) {
            int first = diceArray[0];
            int count = 0;
            for(int i = 1; i < 5; i++) {
                if(first == diceArray[i]) {
                    count++;
                }
            }
            if(count >= 4) {
                Yahteez = 50;
            } else {
                Yahteez = 0;
            }
            totalScore += Yahteez;
        } else {
            System.out.println("You already played this category");
        }
    }

    public void checkSmallStraight() {
        Arrays.sort(diceArray);

        if(smallStraight == -1 || smallStraight == 0) {
            String inARow = "1234";
            String inARow2 = "2345";
            String inARow3 = "3456";

            String str = "";
            for(int i = 0; i < diceArray.length; i++) {
                str += diceArray[i];
            }

            if(str.contains(inARow) || str.contains(inARow2) || str.contains(inARow3)) {
                smallStraight = 30;
            } else {
                smallStraight = 0;
            }
            totalScore += smallStraight;
        } else {
            System.out.println("You already played this category");
        }

    }

    public void checkLargeStraight() {
        Arrays.sort(diceArray);

        if(largeStraight == -1 || largeStraight == 0) {
            String inARow = "12345";
            String inARow2 = "23456";

            String str = "";
            for(int i = 0; i < diceArray.length; i++) {
                str += diceArray[i];
            }

            if(str.contains(inARow) || str.contains(inARow2)) {
                largeStraight = 40;
            } else {
                largeStraight = 0;
            }
            totalScore += largeStraight;
        } else {
            System.out.println("You already played this category");
        }
    }

    public void checkChanceAdd() {
        if(chanceAdd == -1 || chanceAdd == 0) {
            int chance = 0;
            for(int i = 0; i < 5; i++) {
                chance += diceArray[i];
            }
            chanceAdd = chance;
            totalScore += chanceAdd;
        } else {
            System.out.println("You already played this category");
        }
    }

    public void checkFullHouse() {
        int[] five = new int[5];
        for(int i = 0; i < 5; i++) {
            five[i] = diceArray[i];
        }
        Arrays.sort(five);

        if(fullHouse == -1 || fullHouse == 0) {
            int count = 0;
            if(five[0] == five[1] && five[1] == five[2] || five[0] == five[1] && five[2] != five[1]){
                count++;
            }
            if(five[3] == five[4]){
                count++;
            }
            if(count > 1){
                fullHouse = 25;
            } else {
                fullHouse = 0;
            }
            totalScore += fullHouse;
        } else {
            System.out.println("You already played this category");

        }
    }
}

