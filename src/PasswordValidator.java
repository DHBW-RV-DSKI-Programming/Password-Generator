class PasswordValidator {

    private final UserSelection userSelection;

    PasswordValidator(UserSelection userSelection) {
        this.userSelection = userSelection;
    }

    boolean isValid(String password, int nextCharValue, int lastCharValue) {
        char nextChar = (char) nextCharValue;
        char lastChar = (char) lastCharValue;

        if (userSelection.isNoRepeatsSelected() && password.contains(String.valueOf(nextChar))) {
            return false;
        }
        if (userSelection.isNoSequentialDigitsSelected() && Character.isDigit(nextChar) && Character.isDigit(lastChar) && lastCharValue != -1
                && Math.abs(nextCharValue - lastCharValue) == 1) {
                return false;
        }
        return true;
    }

}