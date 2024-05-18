import java.util.ArrayList;
import java.util.List;

public class AllFilesManager
{
    private ArrayList<Integer> allWordsCounts = new ArrayList<>();
    private ArrayList<String> allLongestWords = new ArrayList<>();
    private ArrayList<String> allShortestWords = new ArrayList<>();
    private ArrayList<Integer> allLengthAvg = new ArrayList<>();

    public synchronized void addInfo(ArrayList<Object> infos)
    {
        allWordsCounts.add((Integer) infos.get(0));
        allLongestWords.add((String) infos.get(1));
        allShortestWords.add((String) infos.get(2));
        allLengthAvg.add((Integer) infos.get(3));
    }

    private int count()
    {
        int result = 0;
        for (Integer i :allWordsCounts)
        {
            result += i;
        }
        return result;
    }
    private String longestWord()
    {
        String result = ".";
        for (String s :allLongestWords)
        {
            if(s.length() > result.length())
                result = s;
        }
        return result;
    }
    private String shortestWord()
    {
        String result = ".";
        for (String s :allShortestWords)
        {
            if (s.length() > result.length())
                result = s;
        }
        return result;
    }
    private int avg()
    {
        int result = 0;
        for (Integer i : allLengthAvg)
        {
            result += i;
        }
        return result / allLengthAvg.size();
    }
    public List<Object> giveResults()
    {
        List<Object> results = new ArrayList<>();
        results.add(count());
        results.add(longestWord());
        results.add(shortestWord());
        results.add(avg());
        return results;
    }
}
