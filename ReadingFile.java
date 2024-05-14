import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReadingFile implements Runnable
{
    File file;
    ArrayList<String> lines;
    int wordCount = 0;
    String longestWord;
    String shortestWord;
    int allWordsLengthAvg = 0;
    public ReadingFile(File file)
    {
        this.file = file;
    }
    @Override
    public void run()
    {
        try (FileInputStream fIn = new FileInputStream(file))
        {
            lines = (ArrayList<String>) Files.readAllLines(file.toPath());
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
        String temp;
        for (String word : lines)
        {
            temp = word;
            if (temp.length() > result.length())
                result = temp;
        }
        return result;
    }

    private String findShortestWord()
    {
        String result = ".";
        String temp;
        for (String word : lines)
        {
            temp = word;
            if (temp.length() < result.length())
                result = temp;
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
    public List<Object> giveResults()
    {
        List<Object> results = new ArrayList<>();
        results.add(wordCount);
        results.add(longestWord);
        results.add(shortestWord);
        results.add(allWordsLengthAvg);
        return results;
    }
}
