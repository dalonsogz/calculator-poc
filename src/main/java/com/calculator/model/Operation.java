package com.calculator.model;

public enum Operation {
    ADDITION, SUBTRACTION;
    private static final Operation[] values = new Operation[]{ADDITION, SUBTRACTION};

    public String getName() {
        return this.name();
    }
}
