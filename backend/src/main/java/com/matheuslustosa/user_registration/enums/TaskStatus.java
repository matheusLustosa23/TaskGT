package com.matheuslustosa.user_registration.enums;

public enum TaskStatus {
    TO_DO("To Do"),
    IN_PROGRESS("In Progress"),
    PAUSED("Paused"),
    COMPLETED("Completed"),
    CANCELED("Canceled"),
    OVERDUE("Overdue");

    private final String label;

    TaskStatus(String label){
        this.label = label;
    }


    public String getLabel() {
        return label;
    }
}
