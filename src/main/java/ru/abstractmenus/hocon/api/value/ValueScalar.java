package ru.abstractmenus.hocon.api.value;

public class ValueScalar extends AbstractValue {

    private Object value;

    public ValueScalar(Object value) {
        this.value = value;
    }

    @Override
    public boolean isScalar() {
        return true;
    }

}
