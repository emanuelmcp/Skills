package emanuelmcp.io.github.skills.database.dao;

import emanuelmcp.io.github.skills.database.models.Account;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public interface DAO<T, K>{
    Optional<T> get(@NotNull String id);
    List<T> getAll();
    void save(T t);
    void update(T t, String[] params);
    void delete(T t);
}
