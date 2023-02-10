import org.junit.jupiter.api.Test;
import org.abstractmenus.hocon.api.ConfigNode;
import org.abstractmenus.hocon.api.ConfigurationLoader;
import org.abstractmenus.hocon.api.serialize.NodeSerializeException;
import org.abstractmenus.hocon.api.serialize.NodeSerializer;
import org.abstractmenus.hocon.api.serialize.NodeSerializers;
import org.abstractmenus.hocon.api.source.ConfigSource;
import org.abstractmenus.hocon.api.source.ConfigSources;

import java.util.List;

public class TempTests {

    @Test
    public void test() throws Exception {
        ConfigSource source = ConfigSources.resource("test.conf", this);
        NodeSerializers serializers = NodeSerializers.defaults();
        NodeSerializers serializers1 = NodeSerializers.defaults();

        serializers1.register(User.class, new UserSerializer());

        ConfigurationLoader loader = ConfigurationLoader.builder()
                .source(source)
                .serializers(serializers.merge(serializers1))
                .build();
        ConfigNode node = loader.load();

        System.out.println(node.toString());
        System.out.println(node.node("str").getList(String.class));
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
        public User deserialize(Class<User> type, ConfigNode node) throws NodeSerializeException {
            User user = new User();
            user.name = node.node("name").getString();
            user.age = node.node("age").getInt();
            user.friends = node.node("friends").getList(String.class);
            return user;
        }

    }

}
