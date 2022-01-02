package ru.abstractmenus.hocon.api.serialize.defaults;

import ru.abstractmenus.hocon.api.ConfigNode;
import ru.abstractmenus.hocon.api.serialize.NodeSerializer;

public class BooleanSerializer implements NodeSerializer<Boolean> {

    @Override
    public Boolean deserialize(Class<?> type, ConfigNode node) {
        Object obj = node.wrapped().unwrapped();
        return obj instanceof Boolean ? (Boolean) obj : obj.toString().equalsIgnoreCase("true");
    }

}
