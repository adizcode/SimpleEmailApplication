package app.enums;

import app.utils.Utilities;

public enum Department {
    SALES, DEVELOPMENT, ACCOUNTING;

    private final String name;

    Department() {
        String defaultName = name();
        name = Utilities.capitalizeString(defaultName);
    }

    @Override
    public String toString() {
        return name;
    }
}
