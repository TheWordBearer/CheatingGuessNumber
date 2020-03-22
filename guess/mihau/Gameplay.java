package guess.mihau;

public class Gameplay {
    private static int tries;
    private static int myNumber;
    private static int minRange;
    private static int maxRange;
    final static int STARTING_MIN_RANGE = 1;
    final static int STARTING_MAX_RANGE = 100;

    public static int changeNumberOfTries() {
        final int MIN_TRIES = 1;
        final int MAX_TRIES = 100;

        System.out.println(Messages.CHANGING_NUMBER_OF_TRIES.view() +
                +MIN_TRIES + " to " + MAX_TRIES + "):");

        int userInput = InputManager.getInput();

        if (userInput >= MIN_TRIES && userInput <= MAX_TRIES) {
            return userInput;
        } else {
            System.out.println(Messages.ERROR_NUMBER_OF_TRIES_OUT_OF_RANGE.view());
            return -1;
        }
    }

    public static void play(int chances) {
        int userInput;
        myNumber = Randomizer.getRandomInt();
        tries = chances;

        minRange = STARTING_MIN_RANGE;
        maxRange = STARTING_MAX_RANGE;

        while (tries > 0) {
            System.out.println(Messages.GUESS_NUMBER_IN_RANGE.view() + minRange + " to " + maxRange + ".");
            userInput = InputManager.getInput();
            if (userInput > 0) {
                if (userInput > myNumber) {
                    numberToHigh(userInput);
                    continue;
                } else if (userInput < myNumber) {
                    numberToLow(userInput);
                    continue;
                } else {
                    if (cheatAttempt(userInput)) {
                        continue;
                    }
                    System.out.println(Messages.WON.view() + myNumber + ".");
                    System.out.println(Messages.TRIES_TO_WIN.view() + (chances - tries) + ".\n");
                    break;
                }
            } else {
                tries--;
                System.out.println(Messages.ERROR_WRONG_INPUT.view() + tries + ".");
            }
        }
        if (tries == 0) {
            System.out.println(Messages.LOST.view());
        }
    }

    private static void numberToHigh(int userInput) {
        tries--;
        if (userInput < maxRange) {
            maxRange = userInput;
        }
        System.out.println(Messages.GUESSED_NUMBER_TOO_HIGH.view() + tries);
    }

    private static void numberToLow(int userInput) {
        tries--;
        if (userInput > minRange) {
            minRange = userInput;
        }
        System.out.println(Messages.GUESSED_NUMBER_TOO_LOW.view() + tries);
    }

    private static boolean cheatAttempt(int userInput) {
        int countingDownRange = minRange - userInput;
        int countingUpRange = maxRange - userInput;
        if (countingDownRange > 1 && countingDownRange > countingUpRange) {
            myNumber = userInput - (countingDownRange / 2);
            System.out.println(Messages.CHEAT_SUCCESSFUL.view());
            numberToHigh(userInput);
            return true;
        }
        else if (countingUpRange > 1 && countingDownRange < countingUpRange) {
            myNumber = userInput + (countingUpRange / 2);
            System.out.println(Messages.CHEAT_SUCCESSFUL.view());
            numberToLow(userInput);
            return true;
        }
        tries--;
        return false;
    }
}
