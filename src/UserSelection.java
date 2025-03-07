class UserSelection {

    private boolean isLowerSelected;
    private boolean isUpperSelected;
    private boolean isDigitsSelected;
    private boolean isSpecialsSelected;
    private boolean isNoRepeatsSelected;
    private boolean isNoSequentialDigitsSelected;

    boolean isLowerSelected() {
        return isLowerSelected;
    }

    boolean isUpperSelected() {
        return isUpperSelected;
    }

    boolean isDigitsSelected() {
        return isDigitsSelected;
    }

    boolean isSpecialsSelected() {
        return isSpecialsSelected;
    }

    boolean isNoRepeatsSelected() {
        return isNoRepeatsSelected;
    }

    boolean isNoSequentialDigitsSelected() {
        return isNoSequentialDigitsSelected;
    }

    boolean isAnySelected() {
        return isLowerSelected || isUpperSelected || isDigitsSelected || isSpecialsSelected || isNoRepeatsSelected || isNoSequentialDigitsSelected;
    }

    void setLowerSelected(boolean lowerSelected) {
        isLowerSelected = lowerSelected;
    }

    void setUpperSelected(boolean upperSelected) {
        isUpperSelected = upperSelected;
    }

    void setDigitsSelected(boolean digitsSelected) {
        isDigitsSelected = digitsSelected;
    }

    void setSpecialsSelected(boolean specialsSelected) {
        isSpecialsSelected = specialsSelected;
    }

    void setNoRepeatsSelected(boolean noRepeatsSelected) {
        isNoRepeatsSelected = noRepeatsSelected;
    }

    void setNoSequentialDigitsSelected(boolean noSequentialDigitsSelected) {
        isNoSequentialDigitsSelected = noSequentialDigitsSelected;
    }
}
