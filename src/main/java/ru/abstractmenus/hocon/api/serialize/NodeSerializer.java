package ru.abstractmenus.hocon.api.serialize;

import ru.abstractmenus.hocon.api.ConfigNode;

public interface NodeSerializer<T> {

    T deserialize(Class<?> type, ConfigNode node) throws NodeSerializeException;

}
