import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class ReadingFile implements Runnable
{
    private File file;
    private ArrayList<String> lines;
    private AllFilesManager manager;
    public ReadingFile(File file ,AllFilesManager manager)
    {
        this.file = file;
        this.manager = manager;
    }
    @Override
    public void run()
    {
        try (FileInputStream fIn = new FileInputStream(file))
        {
            lines = (ArrayList<String>) Files.readAllLines(file.toPath());
            manager.addInfo(getValues());
        }
        catch (IOException e)
        {
            System.out.println("file not found");
        }
    }

    private int countLines()
    {
        return lines.size();
    }
    private String findLongestWord()
    {
        String result = ".";
        for (String word : lines)
        {
            if (word.length() > result.length())
                result = word;
        }
        return result;
    }

    private String findShortestWord()
    {
        String result = ".......";
        for (String word : lines)
        {
            if (word.length() < result.length())
                result = word;
        }
        return result;
    }
    private int findAvgLength()
    {
        int counter = 0;
        for (String word : lines)
        {
            counter += word.length();
        }
        return counter/countLines();
    }
    public ArrayList<Object> getValues()
    {
        ArrayList<Object> results = new ArrayList<>();
        results.add(countLines());
        results.add(findLongestWord());
        results.add(findShortestWord());
        results.add(findAvgLength());
        return results;
    }
}
