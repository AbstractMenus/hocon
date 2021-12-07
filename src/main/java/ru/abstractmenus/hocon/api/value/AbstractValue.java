package ru.abstractmenus.hocon.api.value;

import ru.abstractmenus.hocon.api.ConfigNode;
import ru.abstractmenus.hocon.api.ConfigValue;
import ru.abstractmenus.hocon.api.serialize.NodeSerializeException;

import java.util.List;
import java.util.Map;

public abstract class AbstractValue implements ConfigValue {

    @Override
    public ConfigNode node(Object... path) {
        return null;
    }

    @Override
    public ConfigNode child(Object key) {
        return null;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public boolean isMap() {
        return false;
    }

    @Override
    public boolean isScalar() {
        return false;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public <T> T getValue(Class<T> type) throws NodeSerializeException {
        return null;
    }

    @Override
    public <T> T getValue(Class<T> type, T def) throws NodeSerializeException {
        return null;
    }

    @Override
    public <T> List<T> getList(Class<T> type) throws NodeSerializeException {
        return null;
    }

    @Override
    public List<ConfigNode> childrenList() {
        return null;
    }

    @Override
    public Map<Object, ConfigNode> childrenMap() {
        return null;
    }
}
