import java.util.*;

class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIALS = "!@#$%^&*";

    void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Willkommen zum Passwort-Generator!");

        while (true) {
            int length = getPasswordLength(scanner);
            boolean includeLower = getUserChoice(scanner, "Kleinbuchstaben (a-z)");
            boolean includeUpper = getUserChoice(scanner, "Großbuchstaben (A-Z)");
            boolean includeDigits = getUserChoice(scanner, "Zahlen (0-9)");
            boolean includeSpecials = getUserChoice(scanner, "Sonderzeichen (!@#$%^&*)");
            boolean noRepeats = getUserChoice(scanner, "Keine wiederholten Zeichen");
            boolean noSequentialDigits = getUserChoice(scanner, "Keine aufeinanderfolgenden Zahlen");

            String password = generatePassword(length, includeLower, includeUpper, includeDigits, includeSpecials, noRepeats, noSequentialDigits);
            System.out.println("\nGeneriertes Passwort: " + password + "\n");

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

    private String generatePassword(int length, boolean lower, boolean upper, boolean digits, boolean specials, boolean noRepeats, boolean noSequentialDigits) {
        String charPool = "";
        if (lower) charPool += LOWERCASE;
        if (upper) charPool += UPPERCASE;
        if (digits) charPool += DIGITS;
        if (specials) charPool += SPECIALS;

        if (charPool.isEmpty()) {
            return "Fehler: Keine Zeichenarten ausgewählt!";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        char lastChar = '\0';

        while (password.length() < length) {
            char nextChar = charPool.charAt(random.nextInt(charPool.length()));

            if (noRepeats && !password.isEmpty() && password.indexOf(String.valueOf(nextChar)) != -1) {
                continue;
            }
            if (noSequentialDigits && Character.isDigit(nextChar) && Character.isDigit(lastChar) && Math.abs(nextChar - lastChar) == 1) {
                continue;
            }
            password.append(nextChar);
            lastChar = nextChar;
        }

        return password.toString();
    }
}
