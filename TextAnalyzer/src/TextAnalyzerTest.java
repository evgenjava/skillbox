import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TextAnalyzerTest {

    private String testText = "word1 word2? word3 word4, word1 word1, word 23 w question?";
    private TextAnalyzer ta = new TextAnalyzer(testText);
    @Test
    public void TestWordCount() {
        System.out.println("Test word count");
        int testWordCount = 10;
        List<String> words = ta.getWords();
        assertThat(words, hasSize(testWordCount));

       // Assert.assertEquals(testWordCount, actualWordCount);
    }

    @Test
    public void TestHasItems() {
        System.out.println("Test has items");
        List<String> words = ta.getWords();
        assertThat(words, hasItems("word1", "23", "w"));
    }

    @Test
    public void TestMostFrequentWord() {
        System.out.println("Test most frequent word");
        String testMostFrequentWord = "word1";
        String actualMostFrequentWord = ta.getMostFrequentWord();
        assertThat(actualMostFrequentWord, equalTo(testMostFrequentWord));
        //Assert.assertEquals(testMostFrequentWord, actualMostFrequentWord);
    }
}
