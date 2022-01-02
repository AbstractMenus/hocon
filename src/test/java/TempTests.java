import org.junit.jupiter.api.Test;
import ru.abstractmenus.hocon.api.ConfigNode;
import ru.abstractmenus.hocon.api.ConfigurationLoader;
import ru.abstractmenus.hocon.api.serialize.NodeSerializeException;
import ru.abstractmenus.hocon.api.serialize.NodeSerializer;
import ru.abstractmenus.hocon.api.serialize.NodeSerializers;
import ru.abstractmenus.hocon.api.source.ConfigSource;
import ru.abstractmenus.hocon.api.source.ConfigSources;

import java.util.List;

public class TempTests {

    @Test
    public void test() throws Exception {
        ConfigSource source = ConfigSources.resource("test.conf", this);
        ConfigurationLoader loader = ConfigurationLoader.builder()
                .source(source)
                .serializers(NodeSerializers.defaults()
                        .register(User.class, new UserSerializer()))
                .build();
        ConfigNode node = loader.load();

        System.out.println(node.toString());
        System.out.println(node.node("map", "param1").getString());
        System.out.println(node.node("map", "param15").getString());
        System.out.println(node.node("list").getList(String.class));
        System.out.println(node.node("list_of_lists").getList(List.class));
        System.out.println(node.node("user").getValue(User.class));
        System.out.println(node.node("users").getList(User.class));
    }

    private class User {

        public String name;
        public int age;
        public List<String> friends;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", friends=" + friends +
                    '}';
        }
    }

    private class UserSerializer implements NodeSerializer<User> {

        @Override
        public User deserialize(Class<?> type, ConfigNode node) throws NodeSerializeException {
            User user = new User();
            user.name = node.node("name").getString();
            user.age = node.node("age").getInt();
            user.friends = node.node("friends").getList(String.class);
            return user;
        }

    }

}
