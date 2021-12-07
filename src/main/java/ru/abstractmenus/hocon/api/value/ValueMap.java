package ru.abstractmenus.hocon.api.value;

import java.util.Map;

public class ValueMap extends AbstractValue {

    private final Map value;

    public ValueMap(Map value) {
        this.value = value;
    }

    @Override
    public boolean isMap() {
        return true;
    }
}
