package ru.nanit.hocon;

import ru.nanit.hocon.serialize.NodeSerializeException;

import java.util.List;
import java.util.Map;

public interface ConfigNode {

    /**
     * Get path to this node
     * @return Path to this node
     */
    ConfigNode[] path();

    /**
     * Get node, relative to this one
     * @param path Relative path to node
     * @return Created or found node
     */
    ConfigNode node(Object... path);

    boolean hasChildren();

    boolean isList();

    boolean isMap();

    boolean isScalar();

    /**
     * Get the raw value of this node
     * @return Raw node value
     */
    Object getValue();

    /**
     * Try to deserialize and return value of this node
     * @param type Value type
     * @param <T> Value type
     * @return Deserialized value
     * @throws NodeSerializeException if something wrong while deserializing
     */
    <T> T getValue(Class<T> type) throws NodeSerializeException;

    /**
     * Try to deserialize and return list value of this node
     * @param type Value type
     * @param <T> Value type
     * @return Deserialized value
     * @throws NodeSerializeException if something wrong while deserializing
     */
    <T> List<T> getList(Class<T> type) throws NodeSerializeException;

    List<ConfigNode> childrenList();

    Map<Object, ConfigNode> childrenMap();

    boolean getBoolean(boolean def);

    boolean getBoolean();

    byte getByte(byte def);

    byte getByte();

    short getShort(short def);

    short getShort();

    int getInt(int def);

    int getInt();

    long getLong(long def);

    long getLong();

    float getFloat(float def);

    float getFloat();

    double getDouble(double def);

    double getDouble();

    String getString(String def);

    String getString();

}
