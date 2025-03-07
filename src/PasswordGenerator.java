import java.util.*;

class PasswordGenerator {

    void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Willkommen zum Passwort-Generator!");

        while (true) {
            int length = getPasswordLength(scanner);
            UserSelection userSelection = new UserSelection();

            do {
                userSelection.setLowerSelected(getUserChoice(scanner, "Kleinbuchstaben (a-z)"));
                userSelection.setUpperSelected(getUserChoice(scanner, "Großbuchstaben (A-Z)"));
                userSelection.setDigitsSelected(getUserChoice(scanner, "Zahlen (0-9)"));
                userSelection.setSpecialsSelected(getUserChoice(scanner, "Sonderzeichen (!@#$%^&*)"));
                userSelection.setNoRepeatsSelected(getUserChoice(scanner, "Keine wiederholten Zeichen"));
                userSelection.setNoSequentialDigitsSelected(getUserChoice(scanner, "Keine aufeinanderfolgenden Zahlen"));

                if (!userSelection.isAnySelected()) {
                    System.out.println("Es muss mindestens eine Zeichenart ausgewählt werden!");
                }
            } while (!userSelection.isAnySelected());

            String password = generatePassword(length, userSelection);
            System.out.println("Generiertes Passwort: " + password);

            System.out.print("Möchtest du ein weiteres Passwort generieren? (j/n): ");
            if (!scanner.next().equalsIgnoreCase("j")) {
                System.out.println("Programm beendet.");
                break;
            }
        }
        scanner.close();
    }

    private int getPasswordLength(Scanner scanner) {
        int length;
        do {
            System.out.print("Bitte gib die gewünschte Passwortlänge ein (min. 6 Zeichen): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Ungültige Eingabe. Bitte eine Zahl eingeben: ");
                scanner.next();
            }
            length = scanner.nextInt();
        } while (length < 6);
        return length;
    }

    private boolean getUserChoice(Scanner scanner, String message) {
        System.out.print("- " + message + "? (j/n): ");
        return scanner.next().equalsIgnoreCase("j");
    }

    private String generatePassword(int length, UserSelection userSelection) {
        ArrayList<Integer> charPool = initCharPool(userSelection);

        Random random = new Random();
        String password = "";
        int lastCharValue = -1; // store previous character code

        while (password.length() < length) {
            int nextCharValue = charPool.get(random.nextInt(charPool.size()));
            char nextChar = (char) nextCharValue;
            char lastChar = (char) lastCharValue;

            // Check no repeated characters
            if (userSelection.isNoRepeatsSelected() && password.contains(String.valueOf(nextChar))) {
                continue;
            }
            // Check for no sequential digits
            if (userSelection.isNoSequentialDigitsSelected() && Character.isDigit(nextChar) && Character.isDigit(lastChar) && lastCharValue != -1
                    && Math.abs(nextCharValue - lastCharValue) == 1) {
                continue;
            }
            password += nextChar;
            lastCharValue = nextCharValue;
        }

        return password;
    }

    private ArrayList<Integer> initCharPool(UserSelection userSelection) {
        ArrayList<Integer> charPool = new ArrayList<>();

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
        return charPool;
    }

}
