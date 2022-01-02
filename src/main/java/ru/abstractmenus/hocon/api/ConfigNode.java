package ru.abstractmenus.hocon.api;

import ru.abstractmenus.hocon.ConfigValue;
import ru.abstractmenus.hocon.api.serialize.NodeSerializeException;

import java.util.List;
import java.util.Map;

public interface ConfigNode {

    ConfigValue wrapped();

    String key();

    String[] path();

    ConfigNode parent();

    ConfigNode node(String... path);

    ConfigNode child(String key);

    boolean hasChildren();

    boolean isList();

    boolean isMap();

    boolean isPrimitive();

    boolean isNull();

    Object rawValue();

    default <T> T getValue(Class<T> type) throws NodeSerializeException {
        return getValue(type, null);
    }

    <T> T getValue(Class<T> type, T def) throws NodeSerializeException;

    <T> List<T> getList(Class<T> type) throws NodeSerializeException;

    List<ConfigNode> childrenList();

    Map<String, ConfigNode> childrenMap();

    boolean getBoolean(boolean def);

    default boolean getBoolean() {
        return getBoolean(false);
    }

    int getInt(int def);

    default int getInt() {
        return getInt(0);
    }

    long getLong(long def);

    default long getLong() {
        return getLong(0L);
    }

    float getFloat(float def);

    default float getFloat() {
        return getFloat(0.0F);
    }

    double getDouble(double def);

    default double getDouble() {
        return getDouble(0.0);
    }

    String getString(String def);

    default String getString() {
        return getString(null);
    }

}
