import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main
{
    public static void main(String[] args)
    {
        ExecutorService es = Executors.newCachedThreadPool();
        File folder = new File("src/path");
        File[] files = folder.listFiles();
        assert files != null;
        es.execute(new ReadingFile(files[0]));
    }
}