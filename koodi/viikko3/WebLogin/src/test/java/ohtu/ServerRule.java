package ohtu;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import org.junit.rules.ExternalResource;
import spark.Spark;

public class ServerRule extends ExternalResource {
    
    private final int port;

    public ServerRule(int port) {
        this.port = port;
    }

    @Override
    protected void before() throws Throwable {
<<<<<<< HEAD
        System.setProperty("webdriver.chrome.driver", "chromedriver");
=======
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
        Spark.port(port);
        UserDao dao = new UserDaoForTests();
        dao.add(new User("jukka", "akkuj"));
        Main.setDao(dao);
        Main.main(null);
    }

    @Override
    protected void after() {
        Spark.stop();
    }
    
}
