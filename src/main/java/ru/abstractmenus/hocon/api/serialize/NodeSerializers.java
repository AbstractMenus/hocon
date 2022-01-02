package ru.abstractmenus.hocon.api.serialize;

import ru.abstractmenus.hocon.api.serialize.defaults.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NodeSerializers {

    private final Map<Class<?>, NodeSerializer<?>> serializers;

    public NodeSerializers(Map<Class<?>, NodeSerializer<?>> serializers) {
        this.serializers = serializers;
    }

    public <T> NodeSerializer<T> getSerializer(Class<T> type) throws NodeSerializeException {
        NodeSerializer<T> serializer = (NodeSerializer<T>) serializers.get(type);
        if (serializer == null)
            throw new NodeSerializeException("No serializer for type " + type.getName());
        return serializer;
    }

    public <T> void register(Class<T> type, NodeSerializer<T> serializer) {
        serializers.put(type, serializer);
    }

    /**
     * Create new default serializers list,
     * which contains serializers for all primitive types
     * @return New serializers collection
     */
    public static NodeSerializers defaults() {
        Map<Class<?>, NodeSerializer<?>> map = new HashMap<>();

        map.put(Boolean.class, new BooleanSerializer());
        map.put(Double.class, new DoubleSerializer());
        map.put(Float.class, new FloatSerializer());
        map.put(Integer.class, new IntegerSerializer());
        map.put(Long.class, new LongSerializer());
        map.put(String.class, new StringSerializer());
        map.put(UUID.class, new UuidSerializer());

        return new NodeSerializers(map);
    }

}
