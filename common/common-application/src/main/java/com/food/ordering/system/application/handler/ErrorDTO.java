package com.food.ordering.system.application.handler;

import lombok.Builder;

@Builder
public class ErrorDTO {
    private final String code;
    private final String message;

    public ErrorDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
