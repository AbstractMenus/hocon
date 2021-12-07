package ru.abstractmenus.hocon.api.serialize;

import java.util.HashMap;
import java.util.Map;

public class NodeSerializers {

    private final Map<Class<?>, NodeSerializer<?>> serializers;

    public NodeSerializers(Map<Class<?>, NodeSerializer<?>> serializers) {
        this.serializers = serializers;
    }

    public <T> NodeSerializer<T> getSerializer(Class<T> type) {
        return (NodeSerializer<T>) serializers.get(type);
    }

    public <T> void register(Class<T> type, NodeSerializer<T> serializer) {
        serializers.put(type, serializer);
    }

    public static NodeSerializers defaults() {
        Map<Class<?>, NodeSerializer<?>> map = new HashMap<>();

        // TODO add default serializers

        return new NodeSerializers(map);
    }

}
