import com.test.webscoop.searchengine.BingSearch;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestBingSearch {
    BingSearch bingSearch = new BingSearch();

    @Test
    public void testBingSearchEmptyResults(){
       List<String> webPageLinks =  bingSearch.getWebPageLinks("lkfd23232erfdvcjsjfks");
       Assert.assertEquals(0, webPageLinks.size());
    }

    @Test
    public void testBingSearch(){
       List<String> webPageLinks =  bingSearch.getWebPageLinks("java");
       Assert.assertNotNull(webPageLinks);
    }
}
