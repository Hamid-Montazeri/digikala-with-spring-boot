package ir.mapsa.digikala.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProductType {

    NORMAL("Normal"),
    PROMOTION("Promotion");

    private final String value;

}
