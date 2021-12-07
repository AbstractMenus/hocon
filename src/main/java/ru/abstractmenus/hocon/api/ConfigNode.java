package ru.abstractmenus.hocon.api;

import ru.abstractmenus.hocon.api.serialize.NodeSerializeException;

import java.util.List;
import java.util.Map;

public interface ConfigNode extends ConfigValue {

    Object key();

    Object[] path();

    void setValue(Object value) throws NodeSerializeException;

    boolean getBoolean(boolean def);

    default boolean getBoolean() {
        return getBoolean(false);
    }

    byte getByte(byte def);

    default byte getByte() {
        return getByte((byte) 0);
    }

    short getShort(short def);

    default short getShort() {
        return getShort((short) 0);
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
