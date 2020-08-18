import com.test.webscoop.Error.NoSearchResultsFound;
import com.test.webscoop.WebScoopApp;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestWebScoop {

    public WebScoopApp testWebScoop= new WebScoopApp();

    @Test
    public void testGetResults() throws IOException {
        List<Map.Entry<String, Long>> jsLib = testWebScoop.getResults("java");
        Assert.assertEquals(5, jsLib.size());
    }

    @Test (expected = NoSearchResultsFound.class)
    public void testWebScoopWithEmptySearchKey() throws IOException {
        testWebScoop.getResults("");
    }

    @Test(expected = NoSearchResultsFound.class)
    public void testGetResultsNoResultFound() throws IOException {
        testWebScoop.getResults("lksfjsfjsjfjs");
    }

}
