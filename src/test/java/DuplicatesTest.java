import org.junit.jupiter.api.Test;
import org.abstractmenus.hocon.api.ConfigNode;
import org.abstractmenus.hocon.api.ConfigurationLoader;
import org.abstractmenus.hocon.api.serialize.NodeSerializers;
import org.abstractmenus.hocon.api.source.ConfigSource;
import org.abstractmenus.hocon.api.source.ConfigSources;

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
