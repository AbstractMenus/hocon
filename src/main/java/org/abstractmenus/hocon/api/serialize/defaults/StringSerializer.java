package org.abstractmenus.hocon.api.serialize.defaults;

import org.abstractmenus.hocon.api.serialize.NodeSerializeException;
import org.abstractmenus.hocon.api.serialize.NodeSerializer;
import org.abstractmenus.hocon.api.ConfigNode;
import org.abstractmenus.hocon.api.Preconditions;

public class StringSerializer implements NodeSerializer<String> {

    @Override
    public String deserialize(Class<String> type, ConfigNode node) throws NodeSerializeException {
        Preconditions.checkNodeNull(node);
        Object obj = node.rawValue();
        if (obj instanceof String) return (String) obj;
        return obj.toString();
    }

}
