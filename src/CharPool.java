import java.util.ArrayList;
import java.util.Random;

class CharPool {
    private final ArrayList<Integer> charPool;

    CharPool(UserSelection userSelection) {
        charPool = new ArrayList<>();
        initCharPool(userSelection);
    }

    private void initCharPool(UserSelection userSelection) {
        if (userSelection.isLowerSelected() == true) {
            // a to z
            for (int code = 'a'; code <= (int) 'z'; code++) {
                charPool.add(code);
            }
        }
        if (userSelection.isUpperSelected() == true) {
            // A to Z
            for (int code = 'A'; code <= (int) 'Z'; code++) {
                charPool.add(code);
            }
        }
        if (userSelection.isDigitsSelected() == true) {
            // 0 to 9
            for (int code = '0'; code <= (int) '9'; code++) {
                charPool.add(code);
            }
        }
        if (userSelection.isSpecialsSelected() == true) {
            // Special characters: !@#$%^&*
            int[] specialCodes = {(int) '!', (int) '@', (int) '#', (int) '$', (int) '%', (int) '^', (int) '&', (int) '*'};
            for (int code : specialCodes) {
                charPool.add(code);
            }
        }
    }

    int getRandomChar(Random random) {
        return charPool.get(random.nextInt(charPool.size()));
    }

    int getCharPoolSize() {
        return charPool.size();
    }

}