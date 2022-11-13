package emanuelmcp.io.github.skills.database.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T, K>{
    Optional<T> get(K id);
    List<T> getAll();
    void save(T t);
    void update(T t, String[] params);
    void delete(T t);
}
