package emanuelmcp.io.github.skills.interfaces;

public interface ConnectionManager {
    public void init();
    public void setupPool();
    public void closePool();
    Object getConnection() throws Exception;
}
