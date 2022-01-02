import org.junit.jupiter.api.Test;
import ru.abstractmenus.hocon.api.ConfigNode;
import ru.abstractmenus.hocon.api.ConfigurationLoader;
import ru.abstractmenus.hocon.api.source.ConfigSource;
import ru.abstractmenus.hocon.api.source.ConfigSources;

public class TempTests {

    @Test
    public void test() throws Exception {
        ConfigSource source = ConfigSources.resource("test.conf", this);
        ConfigurationLoader loader = ConfigurationLoader.builder()
                .source(source)
                .build();
        ConfigNode node = loader.load();

        System.out.println(node.toString());

        System.out.println(node.node("map", "param1").getString());
        System.out.println(node.node("list").getList(String.class));
    }

}
