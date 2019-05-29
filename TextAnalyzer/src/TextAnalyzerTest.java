import org.junit.Assert;
import org.junit.Test;

public class TextAnalyzerTest {

    private String testText = "word1 word2? word3 word4, word1 word1, word 23 w question?";
    @Test
    public void TestWordCount() {
        System.out.println("Test word count");
        TextAnalyzer ta = new TextAnalyzer(testText);
        int testWordCount = 9;
        int actualWordCount = ta.getWords().size();
        Assert.assertEquals(testWordCount, actualWordCount);
    }

    @Test
    public void TestMostFrequentWord() {
        System.out.println("Test most frequent word");
        TextAnalyzer ta = new TextAnalyzer(testText);
        String testMostFrequentWord = "word1";
        String actualMostFrequentWord = ta.getMostFrequentWord();
        Assert.assertEquals(testMostFrequentWord, actualMostFrequentWord);
    }
}
