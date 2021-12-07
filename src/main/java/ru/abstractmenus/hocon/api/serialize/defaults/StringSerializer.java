package ru.abstractmenus.hocon.api.serialize.defaults;

import ru.abstractmenus.hocon.api.ConfigNode;
import ru.abstractmenus.hocon.api.serialize.NodeSerializeException;
import ru.abstractmenus.hocon.api.serialize.NodeSerializer;

public class StringSerializer implements NodeSerializer<String> {

    @Override
    public String deserialize(Class<?> type, ConfigNode node) throws NodeSerializeException {
        if (node.isScalar()) {

        }

        throw new NodeSerializeException("String value must be scalar");
    }

}
