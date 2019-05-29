import org.junit.Assert;
import org.junit.Test;

public class TextAnalyzerTest {

    private String text = "word1 word2? word3 word4, word1 word1";
    @Test
    public void TescWordCount() {
        TextAnalyzer ta = new TextAnalyzer(text);
        int testWordCount = 5;
        int actualWordCount = ta.getWords().size();
        Assert.assertEquals(testWordCount, actualWordCount);
    }
}
