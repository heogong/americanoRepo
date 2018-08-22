package com.issac.foundation.user.model;

public enum Level {
    SYS_ADM(1), COMP_ADM(2), EDU_ADM(3), USER(4);

    private final int value;

    Level(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public static Level valueOf(int value) {
        switch (value) {
            case 1:
                return SYS_ADM;
            case 2:
                return COMP_ADM;
            case 3:
                return EDU_ADM;
            case 4:
                return USER;
            default:
                throw new AssertionError("Unknown value: " + value);
        }
    }
}
