package emanuelmcp.io.github.skills.database;
import emanuelmcp.io.github.skills.interfaces.DBConnector;
import redis.clients.jedis.JedisPool;

public class RedisConnector implements DBConnector {
    @Override
    public JedisPool getConnection() {
        return new JedisPool("redis://localhost:60045");
    }
}
