package ru.nanit.hocon;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import ru.nanit.hocon.serialize.NodeSerializer;
import ru.nanit.hocon.serialize.NodeSerializers;
import ru.nanit.hocon.source.ConfigSource;

import java.io.IOException;

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



        return null;
    }

}
