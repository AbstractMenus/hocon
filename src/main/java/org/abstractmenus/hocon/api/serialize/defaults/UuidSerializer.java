package org.abstractmenus.hocon.api.serialize.defaults;

import org.abstractmenus.hocon.api.ConfigNode;
import org.abstractmenus.hocon.api.Preconditions;
import org.abstractmenus.hocon.api.serialize.NodeSerializeException;
import org.abstractmenus.hocon.api.serialize.NodeSerializer;

import java.util.UUID;

public class UuidSerializer implements NodeSerializer<UUID> {

    @Override
    public UUID deserialize(Class<UUID> type, ConfigNode node) throws NodeSerializeException {
        Preconditions.checkNodeNull(node);
        Object obj = node.rawValue();
        if (obj instanceof UUID) return (UUID) obj;
        try {
            return UUID.fromString(node.getString());
        } catch (Exception e) {
            throw new NodeSerializeException(node, "Cannot parse UUID: " + e.getMessage());
        }
    }

}
