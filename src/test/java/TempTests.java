import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.jupiter.api.Test;

public class TempTests {

    @Test
    public void test() {
        Config conf = ConfigFactory.load("test.conf");

    }

}
