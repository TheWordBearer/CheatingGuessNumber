package guess.mihau;

import java.util.Scanner;

public class InputManager {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInput() {
        int input;
        if (scanner.hasNextInt()) {
            input = scanner.nextInt();
            scanner.nextLine();
            return input;
        }
        else {
            scanner.nextLine();
            return -1;
        }
    }
}
