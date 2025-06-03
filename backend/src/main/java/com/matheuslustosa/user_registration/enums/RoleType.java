package com.matheuslustosa.user_registration.enums;

public enum RoleType {
    ADMIN(1),
    USER(2);

    private final long roleID;

    RoleType(long id) {
        this.roleID = id;
    }

    public long getRoleID() {
        return this.roleID;
    }
}
