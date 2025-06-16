package com.perfulandia.post_venta.model;

public enum EnumEstado {
    PENDIENTE(1, "Pendiente"),
    ACEPTADA(2, "Aceptada"),
    RECHAZADA(3, "Rechazada");

    private final int code;
    private final String description;

    EnumEstado(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}