package ru.nanit.hocon.serialize.defaults;

import ru.nanit.hocon.ConfigNode;
import ru.nanit.hocon.serialize.NodeSerializeException;
import ru.nanit.hocon.serialize.NodeSerializer;

public class StringSerializer implements NodeSerializer<String> {

    @Override
    public String deserialize(Class<?> type, ConfigNode node) throws NodeSerializeException {
        if (node.isScalar()) {

        }

        throw new NodeSerializeException("String value must be scalar");
    }

}
