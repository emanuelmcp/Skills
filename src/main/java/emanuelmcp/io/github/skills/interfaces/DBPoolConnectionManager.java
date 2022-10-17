package emanuelmcp.io.github.skills.interfaces;

public interface DBPoolConnectionManager {
    public void init();
    public void setupPool();
    public void closePool();
}
