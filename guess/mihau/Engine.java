package guess.mihau;

public class Engine {
    private static boolean isWorking;
    private static int chances = 7;
    private static final int ERROR_WRONG_VALUE = -1;

    public static void start() {
        isWorking = true;
        System.out.println(Messages.WELCOMING.view());
        displayLoop();
    }

    private static void displayLoop() {
        while (isWorking) {
            printMenu();
            actOnUsersChoice(InputManager.getInput());
        }
    }

    private static void actOnUsersChoice(int usersChoice) {
        switch (usersChoice) {
            case 1: {
                do {
                    chances = Gameplay.changeNumberOfTries();
                }
                while (chances == ERROR_WRONG_VALUE);
                break;
            }
            case 2: {
                Gameplay.play(chances);
                break;
            }
            case 3: {
                quit();
                break;
            }
            default: {
                System.out.println(Messages.ERROR_MENU_INPUT_OUT_OF_RANGE.view());
                break;
            }
        }
    }

    private static void printMenu() {
        System.out.println(Messages.CURRENT_NUMBER_OF_TRIES.view() + chances + ".");
        System.out.println(Messages.MENU.view());
    }

    private static void quit() {
        isWorking = false;
        System.out.println(Messages.GOODBYE.view());
    }
}
