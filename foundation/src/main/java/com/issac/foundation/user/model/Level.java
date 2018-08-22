package com.issac.foundation.user.model;

public enum Level {
    SYS_ADM(0), COMP_ADM(1), EDU_ADM(2), USER(3);

    private final int value;

    Level(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public static Level valueOf(int value) {
        switch (value) {
            case 0:
                return SYS_ADM;
            case 1:
                return COMP_ADM;
            case 2:
                return EDU_ADM;
            case 3:
                return USER;
            default:
                throw new AssertionError("Unknown value: " + value);
        }
    }
}
