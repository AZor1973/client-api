package ru.gb.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OrderStatus {
    CREATED("Создан"),
    PROCESSING("В процессе"),
    COMPLETED("Завершен"),
    CANCELED("Отменен");

    private final String title;
}
