/**
 *   Copyright (C) 2011-2012 Typesafe Inc. <http://typesafe.com>
 */
package ru.abstractmenus.hocon.impl;

import java.io.ObjectStreamException;
import java.io.Serializable;

import ru.abstractmenus.hocon.ConfigOrigin;
import ru.abstractmenus.hocon.ConfigValueType;

final class ConfigBoolean extends AbstractConfigValue implements Serializable {

    private static final long serialVersionUID = 2L;

    final private boolean value;

    ConfigBoolean(ConfigOrigin origin, boolean value) {
        super(origin);
        this.value = value;
    }

    @Override
    public ConfigValueType valueType() {
        return ConfigValueType.BOOLEAN;
    }

    @Override
    public Boolean unwrapped() {
        return value;
    }

    @Override
    String transformToString() {
        return value ? "true" : "false";
    }

    @Override
    protected ConfigBoolean newCopy(ConfigOrigin origin) {
        return new ConfigBoolean(origin, value);
    }

    // serialization all goes through SerializedConfigValue
    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }
}
