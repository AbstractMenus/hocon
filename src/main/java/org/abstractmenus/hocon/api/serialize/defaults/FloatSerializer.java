package org.abstractmenus.hocon.api.serialize.defaults;

import org.abstractmenus.hocon.api.ConfigNode;
import org.abstractmenus.hocon.api.Preconditions;
import org.abstractmenus.hocon.api.serialize.NodeSerializeException;
import org.abstractmenus.hocon.api.serialize.NodeSerializer;

public class FloatSerializer implements NodeSerializer<Float> {

    @Override
    public Float deserialize(Class<Float> type, ConfigNode node) throws NodeSerializeException {
        Preconditions.checkNodeNull(node);
        Object obj = node.rawValue();
        if (obj instanceof Float) return (Float) obj;
        try {
            return Float.parseFloat(obj.toString());
        } catch (NumberFormatException e) {
            throw new NodeSerializeException(node, "Cannot parse float from '" + obj + "'");
        }
    }

}
