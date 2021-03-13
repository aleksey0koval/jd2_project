package it.academy.model.user;

import lombok.Data;


public enum Permission {
    DEV_READ("dev:read"),
    DEV_WRITE("dev:write");

    private final String permisiion;

    Permission(String permisiion) {
        this.permisiion = permisiion;
    }

    public String getPermisiion() {
        return permisiion;
    }
}
