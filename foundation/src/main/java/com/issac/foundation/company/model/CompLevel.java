package com.issac.foundation.company.model;

public enum CompLevel {
    NONE(0), CORP(1), ACADEMY(2);

    private final int value;

    CompLevel(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public static CompLevel valueOf(int value) {
        switch (value) {
            case 1:
                return CORP;
            case 2:
                return ACADEMY;
            default:
                throw new AssertionError("Unknown value: " + value);
        }
    }
}
