package com.matheuslustosa.user_registration.enums;

public enum TaskPriority {

    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High"),
    CRITICAL("Critical");



    private final String label;
    TaskPriority (String label){
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
