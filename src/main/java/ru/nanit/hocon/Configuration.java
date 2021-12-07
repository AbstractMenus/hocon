package ru.nanit.hocon;

import ru.nanit.hocon.serialize.NodeSerializeException;
import ru.nanit.hocon.serialize.NodeSerializers;
import ru.nanit.hocon.source.ConfigSource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Configuration implements ConfigNode {

    private final ConfigurationLoader loader;
    private ConfigNode root;

    public Configuration(ConfigNode root, ConfigurationLoader loader) {
        this.loader = loader;
        this.root = root;
    }

    public void reload() throws IOException {
        this.root = loader.load();
    }

    public static Configuration load(ConfigSource source, NodeSerializers serializers) throws IOException {
        ConfigurationLoader loader = new ConfigurationLoader(source, serializers);
        return new Configuration(loader.load(), loader);
    }

    public ConfigNode root() {
        return root;
    }

    @Override
    public ConfigNode[] path() {
        return root.path();
    }

    @Override
    public ConfigNode node(Object... path) {
        return root.node(path);
    }

    @Override
    public boolean hasChildren() {
        return root.hasChildren();
    }

    @Override
    public boolean isList() {
        return root.isList();
    }

    @Override
    public boolean isMap() {
        return root.isMap();
    }

    @Override
    public boolean isScalar() {
        return root.isScalar();
    }

    @Override
    public Object getValue() {
        return root.getValue();
    }

    @Override
    public <T> T getValue(Class<T> type) throws NodeSerializeException {
        return root.getValue(type);
    }

    @Override
    public <T> List<T> getList(Class<T> type) throws NodeSerializeException {
        return root.getList(type);
    }

    @Override
    public List<ConfigNode> childrenList() {
        return root.childrenList();
    }

    @Override
    public Map<Object, ConfigNode> childrenMap() {
        return root.childrenMap();
    }

    @Override
    public boolean getBoolean(boolean def) {
        return false;
    }

    @Override
    public boolean getBoolean() {
        return false;
    }

    @Override
    public byte getByte(byte def) {
        return root.getByte(def);
    }

    @Override
    public byte getByte() {
        return root.getByte();
    }

    @Override
    public short getShort(short def) {
        return root.getShort(def);
    }

    @Override
    public short getShort() {
        return root.getShort();
    }

    @Override
    public int getInt(int def) {
        return root.getInt(def);
    }

    @Override
    public int getInt() {
        return root.getInt();
    }

    @Override
    public long getLong(long def) {
        return root.getLong(def);
    }

    @Override
    public long getLong() {
        return root.getLong();
    }

    @Override
    public float getFloat(float def) {
        return root.getFloat(def);
    }

    @Override
    public float getFloat() {
        return root.getFloat();
    }

    @Override
    public double getDouble(double def) {
        return root.getDouble(def);
    }

    @Override
    public double getDouble() {
        return root.getDouble();
    }

    @Override
    public String getString(String def) {
        return root.getString(def);
    }

    @Override
    public String getString() {
        return root.getString();
    }
}
