package ru.nanit.hocon.serialize;

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
}
