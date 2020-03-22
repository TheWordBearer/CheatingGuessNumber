package guess.mihau;

import java.util.Random;

public class Randomizer {
    private static Random random = new Random();
    private static final int MAX_VALUE = 99;

    public static int getRandomInt() {
        return (random.nextInt(MAX_VALUE) + 1);
    }
}
