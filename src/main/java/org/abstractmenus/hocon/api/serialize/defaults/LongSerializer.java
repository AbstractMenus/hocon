package org.abstractmenus.hocon.api.serialize.defaults;

import org.abstractmenus.hocon.api.serialize.NodeSerializeException;
import org.abstractmenus.hocon.api.serialize.NodeSerializer;
import org.abstractmenus.hocon.api.ConfigNode;
import org.abstractmenus.hocon.api.Preconditions;

public class LongSerializer implements NodeSerializer<Long> {

    @Override
    public Long deserialize(Class<Long> type, ConfigNode node) throws NodeSerializeException {
        Preconditions.checkNodeNull(node);
        Object obj = node.rawValue();
        if (obj instanceof Long) return (Long) obj;
        try {
            return Long.parseLong(obj.toString());
        } catch (NumberFormatException e) {
            throw new NodeSerializeException(node, "Cannot parse long from '" + obj + "'");
        }
    }

}
