import org.junit.jupiter.api.Test;
import ru.abstractmenus.hocon.api.ConfigNode;
import ru.abstractmenus.hocon.api.ConfigurationLoader;
import ru.abstractmenus.hocon.api.serialize.NodeSerializers;
import ru.abstractmenus.hocon.api.source.ConfigSource;
import ru.abstractmenus.hocon.api.source.ConfigSources;

public class DuplicatesTest {

    @Test
    void test() throws Exception {
        ConfigSource source = ConfigSources.resource("duplicates.conf", this);
        NodeSerializers serializers = NodeSerializers.defaults();

        ConfigurationLoader loader = ConfigurationLoader.builder()
                .source(source)
                .serializers(serializers)
                .build();

        ConfigNode node = loader.load();

        System.out.println(node.rawValue().toString());
    }

}
