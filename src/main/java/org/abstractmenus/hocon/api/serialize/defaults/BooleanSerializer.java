package org.abstractmenus.hocon.api.serialize.defaults;

import org.abstractmenus.hocon.api.ConfigNode;
import org.abstractmenus.hocon.api.Preconditions;
import org.abstractmenus.hocon.api.serialize.NodeSerializeException;
import org.abstractmenus.hocon.api.serialize.NodeSerializer;

public class BooleanSerializer implements NodeSerializer<Boolean> {

    @Override
    public Boolean deserialize(Class<Boolean> type, ConfigNode node) throws NodeSerializeException {
        Preconditions.checkNodeNull(node);
        Object obj = node.rawValue();
        return obj instanceof Boolean ? (Boolean) obj : obj.toString().equalsIgnoreCase("true");
    }

}
