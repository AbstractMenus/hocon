package ru.abstractmenus.hocon.api.serialize.defaults;

import ru.abstractmenus.hocon.api.ConfigNode;
import ru.abstractmenus.hocon.api.serialize.NodeSerializeException;
import ru.abstractmenus.hocon.api.serialize.NodeSerializer;

public class IntegerSerializer implements NodeSerializer<Integer> {

    @Override
    public Integer deserialize(Class<?> type, ConfigNode node) throws NodeSerializeException {
        Object obj = node.wrapped().unwrapped();

        if (obj instanceof Integer)
            return (Integer) obj;

        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            throw new NodeSerializeException("Cannot parse int from " + obj);
        }
    }

}
