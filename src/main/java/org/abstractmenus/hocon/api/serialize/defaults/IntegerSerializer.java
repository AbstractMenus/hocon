package org.abstractmenus.hocon.api.serialize.defaults;

import org.abstractmenus.hocon.api.ConfigNode;
import org.abstractmenus.hocon.api.Preconditions;
import org.abstractmenus.hocon.api.serialize.NodeSerializeException;
import org.abstractmenus.hocon.api.serialize.NodeSerializer;

public class IntegerSerializer implements NodeSerializer<Integer> {

    @Override
    public Integer deserialize(Class<Integer> type, ConfigNode node) throws NodeSerializeException {
        Preconditions.checkNodeNull(node);
        Object obj = node.rawValue();
        if (obj instanceof Integer) return (Integer) obj;
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            throw new NodeSerializeException(node, "Cannot parse int from '" + obj + "'");
        }
    }

}
