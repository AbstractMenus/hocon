package ru.abstractmenus.hocon.api;

import ru.abstractmenus.hocon.api.serialize.NodeSerializeException;
import ru.abstractmenus.hocon.api.value.ValueList;
import ru.abstractmenus.hocon.api.value.ValueMap;
import ru.abstractmenus.hocon.api.value.ValueNull;
import ru.abstractmenus.hocon.api.value.ValueScalar;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SimpleConfigNode implements ConfigNode {

    private final ConfigurationLoader loader;
    private final Object key;
    private final Object[] path;

    private ConfigValue value;

    public SimpleConfigNode(Object[] path, ConfigurationLoader loader) {
        this.path = path;
        this.key = path != null ? path[path.length - 1] : null;
        this.loader = loader;
        this.value = new ValueNull();
    }

    public ConfigurationLoader getLoader() {
        return loader;
    }

    @Override
    public Object key() {
        return key;
    }

    @Override
    public Object[] path() {
        return path;
    }

    @Override
    public ConfigNode node(Object... path) {
        ConfigNode node = this;

        for (Object key : path) {
            node = node.child(key);
        }

        return node;
    }

    @Override
    public ConfigNode child(Object key) {
        return value.child(key);
    }

    @Override
    public boolean hasChildren() {
        return value.hasChildren();
    }

    @Override
    public boolean isList() {
        return value.isList();
    }

    @Override
    public boolean isMap() {
        return value.isMap();
    }

    @Override
    public boolean isScalar() {
        return value.isScalar();
    }

    @Override
    public boolean isNull() {
        return value.isNull();
    }

    @Override
    public Object getValue() {
        return value.getValue();
    }

    @Override
    public void setValue(Object value) throws NodeSerializeException {
        if (value instanceof Map) {
            this.value = new ValueMap((Map) value);
        } else if (value instanceof Collection) {
            this.value = new ValueList();
        } else {
            this.value = new ValueScalar(value);
        }
    }

    @Override
    public <T> T getValue(Class<T> type) throws NodeSerializeException {
        return value.getValue(type);
    }

    @Override
    public <T> T getValue(Class<T> type, T def) throws NodeSerializeException {
        return value.getValue(type, def);
    }

    @Override
    public <T> List<T> getList(Class<T> type) throws NodeSerializeException {
        return value.getList(type);
    }

    @Override
    public List<ConfigNode> childrenList() {
        return value.childrenList();
    }

    @Override
    public Map<Object, ConfigNode> childrenMap() {
        return value.childrenMap();
    }

    @Override
    public boolean getBoolean(boolean def) {
        try {
            return value.getValue(Boolean.class, def);
        } catch (NodeSerializeException e) {
            return def;
        }
    }

    @Override
    public byte getByte(byte def) {
        try {
            return value.getValue(Byte.class, def);
        } catch (NodeSerializeException e) {
            return def;
        }
    }

    @Override
    public short getShort(short def) {
        try {
            return value.getValue(Short.class, def);
        } catch (NodeSerializeException e) {
            return def;
        }
    }

    @Override
    public int getInt(int def) {
        try {
            return value.getValue(Integer.class, def);
        } catch (NodeSerializeException e) {
            return def;
        }
    }

    @Override
    public long getLong(long def) {
        try {
            return value.getValue(Long.class, def);
        } catch (NodeSerializeException e) {
            return def;
        }
    }

    @Override
    public float getFloat(float def) {
        try {
            return value.getValue(Float.class, def);
        } catch (NodeSerializeException e) {
            return def;
        }
    }

    @Override
    public double getDouble(double def) {
        try {
            return value.getValue(Double.class, def);
        } catch (NodeSerializeException e) {
            return def;
        }
    }

    @Override
    public String getString(String def) {
        try {
            return value.getValue(String.class, def);
        } catch (NodeSerializeException e) {
            return def;
        }
    }
}
