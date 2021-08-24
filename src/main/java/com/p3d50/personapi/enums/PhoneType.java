package com.p3d50.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    COMERCIAL_PHONE("Comercial"),
    MOBILE_PHONE("Moblie"),
    HOME_PHONE("Home");

    private final String description;
}
