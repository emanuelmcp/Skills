package emanuelmcp.io.github.skills.database.managers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import emanuelmcp.io.github.skills.annotations.PostConstruct;
import emanuelmcp.io.github.skills.interfaces.ConnectionManager;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.sql.SQLException;

@Singleton
public class RedisPoolConnectionManager extends DBConfig implements ConnectionManager {
    @Inject
    private FileConfiguration config;
    @Inject
    private JedisPoolConfig poolConfig;
    @Getter
    private JedisPool pool;
    @Override
    @PostConstruct
    public void init() {
        hostname = config.getString("cache_db.hostname");
        port = config.getString("cache_db.port");
        username = config.getString("cache_db.username");
        password = config.getString("cache_db.password");
    }
    @Override
    @PostConstruct
    public void setupPool(){
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);
        pool = new JedisPool(poolConfig, hostname, Integer.parseInt(port), username, password);
    }
    @Override
    public void closePool() {
        if (pool != null && !pool.isClosed()) {
            pool.close();
        }
    }
    @Override
    public Object getConnection() throws SQLException {
        return pool.getResource();
    }
    /*public void close(Connection conn, PreparedStatement ps, ResultSet res) {
        if (conn != null) try { conn.close(); } catch (SQLException ignored) {}
        if (ps != null) try { ps.close(); } catch (SQLException ignored) {}
        if (res != null) try { res.close(); } catch (SQLException ignored) {}
    }*/
}
