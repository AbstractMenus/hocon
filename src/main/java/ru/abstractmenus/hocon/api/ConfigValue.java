package ru.abstractmenus.hocon.api;

import ru.abstractmenus.hocon.api.serialize.NodeSerializeException;

import java.util.List;
import java.util.Map;

public interface ConfigValue {

    ConfigNode node(Object... path);

    ConfigNode child(Object key);

    boolean hasChildren();

    boolean isList();

    boolean isMap();

    boolean isScalar();

    boolean isNull();

    Object getValue();

    <T> T getValue(Class<T> type) throws NodeSerializeException;

    <T> T getValue(Class<T> type, T def) throws NodeSerializeException;

    <T> List<T> getList(Class<T> type) throws NodeSerializeException;

    List<ConfigNode> childrenList();

    Map<Object, ConfigNode> childrenMap();

}
