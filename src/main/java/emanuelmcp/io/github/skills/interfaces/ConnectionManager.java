package emanuelmcp.io.github.skills.interfaces;

import emanuelmcp.io.github.skills.annotations.PostConstruct;

public interface ConnectionManager {
    public void init();
    public void setupPool();
    public void closePool();
    Object getConnection() throws Exception;
}
