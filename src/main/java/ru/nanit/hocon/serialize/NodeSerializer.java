package ru.nanit.hocon.serialize;

import ru.nanit.hocon.ConfigNode;

public interface NodeSerializer<T> {

    T deserialize(Class<?> type, ConfigNode node) throws NodeSerializeException;

}
