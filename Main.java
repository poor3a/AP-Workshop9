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
        AllFilesManager manager = new AllFilesManager();
        for (File file : files)
        {
            ReadingFile read = new ReadingFile(file ,manager);
            es.execute(read);
        }
        es.shutdown();
        while(!es.isTerminated())
        {
        }
            for (Object o : manager.giveResults()) {
                System.out.println(o);
            }

    }
}