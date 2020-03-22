package guess.mihau;

public enum Messages {
    WELCOMING("------------------------------------------------------------------------------------------------------\n" +
            "Jon: Hi, I'm Jon! Welcome to guess a number!\n" +
            "Jon: It is a game in which I pick a random number from 1 to 100 and your goal is to guess that number.\n" +
            "Jon: You can change the number of tries in which you will have to guess my number.\n" +
            "------------------------------------------------------------------------------------------------------"),
    MENU("Jon: Please, enter a number from menu below:\n" +
            "\t1. Change number of tries,\n" +
            "\t2. Start a game,\n" +
            "\t3. Quit game."),
    GOODBYE("Jon: Bye!"),
    CURRENT_NUMBER_OF_TRIES("Jon: Number of tries, in which you'll guess my number is currently set to "),
    CHANGING_NUMBER_OF_TRIES("Jon: Please enter new value for a number of tries, in which you'll guess my number (in range from "),
    GUESS_NUMBER_IN_RANGE("Jon: Guess my number! It's is range of "),
    GUESSED_NUMBER_TOO_HIGH("Jon: Your number is too high! Number of tries left is "),
    GUESSED_NUMBER_TOO_LOW("Jon: Your number is too low! Number of tries left is "),
    WON("............................................................................\n" +
            "Jon: Great! You won! The number was "),
    TRIES_TO_WIN("Jon: Number of tries it took you to win is "),
    LOST("............................................................................\n" +
            "Jon: Sorry! You're out of tries to guess my number!\n"),
    ERROR_MENU_INPUT_OUT_OF_RANGE("Jon: You did something wrong. Please, enter a number from 1 to 3.\n"),
    ERROR_NUMBER_OF_TRIES_OUT_OF_RANGE("Jon: You did something wrong. Number of tries has to be in range of 1 to 100."),
    ERROR_WRONG_INPUT("Jon: You did not enter a number, you entered negative number or you entered zero... Nice try! Number of tries left is "),
    CHEAT_SUCCESSFUL("Jon: *Grinned*"),
    ;

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String view() {
        return message;
    }
}
