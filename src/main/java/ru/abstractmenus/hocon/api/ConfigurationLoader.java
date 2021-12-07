package ru.abstractmenus.hocon.api;

import ru.abstractmenus.hocon.Config;
import ru.abstractmenus.hocon.ConfigFactory;
import ru.abstractmenus.hocon.ConfigValue;
import ru.abstractmenus.hocon.api.source.ConfigSource;
import ru.abstractmenus.hocon.api.serialize.NodeSerializers;

import java.io.IOException;
import java.util.Map;

public class ConfigurationLoader {

    private final ConfigSource source;
    private final NodeSerializers serializers;

    public ConfigurationLoader(ConfigSource source, NodeSerializers serializer) {
        this.source = source;
        this.serializers = serializer;
    }

    public NodeSerializers getSerializers() {
        return serializers;
    }

    public ConfigNode load() throws IOException {
        Config conf = ConfigFactory.parseReader(source.getReader());
        ConfigNode root = new SimpleConfigNode(null, this);

        for (Map.Entry<String, ConfigValue> ent : conf.root().entrySet()) {
            convertNode(ent.getValue(), root.node(ent.getKey()));
        }

        return root;
    }

    private void convertNode(ConfigValue value, ConfigNode node) {
        switch (value.valueType()) {
            case NULL:
                break;
            case OBJECT:
                break;
            case LIST:
                break;
            case NUMBER:
            case BOOLEAN:
            case STRING:
                // Scalar
                break;
        }
    }

}
