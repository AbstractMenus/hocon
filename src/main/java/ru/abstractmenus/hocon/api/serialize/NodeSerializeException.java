package ru.abstractmenus.hocon.api.serialize;

import ru.abstractmenus.hocon.api.ConfigNode;

public class NodeSerializeException extends Exception {

    public NodeSerializeException(String message) {
        super(message);
    }

    public NodeSerializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NodeSerializeException(Throwable cause) {
        super(cause);
    }

    public NodeSerializeException(ConfigNode node, String message) {
        super((node.wrapped().origin().lineNumber() != -1 ? "[line "+node.wrapped().origin().lineNumber()+"]" : "") + message);
    }
}
