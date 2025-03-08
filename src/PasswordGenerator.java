import java.util.Random;
import java.util.Scanner;

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

            CharPool charPool = new CharPool(userSelection);
            if (userSelection.isNoRepeatsSelected() && charPool.getCharPoolSize() < length) {
                System.out.println("Die gewählten Zeichen reichen nicht aus, um ein Passwort der gewünschten Länge zu generieren.");
                continue;
            }

            PasswordValidator validator = new PasswordValidator(userSelection);

            String password = generatePassword(length, charPool, validator);
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

    private String generatePassword(int length, CharPool charPool, PasswordValidator validator) {
        Random random = new Random();
        String password = "";
        int lastCharValue = -1; // store previous character code

        while (password.length() < length) {
            int nextCharValue = charPool.getRandomChar(random);
            char nextChar = (char) nextCharValue;

            if (!validator.isValid(password, nextChar, lastCharValue)) {
                continue;
            }

            password += nextChar;
            lastCharValue = nextCharValue;
        }

        return password;
    }

}
