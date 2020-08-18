import com.test.webscoop.js.ExtractLibrariesImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

public class TestExtractLibrariesImpl {

    private  ExtractLibrariesImpl extractLibraries = mock(ExtractLibrariesImpl.class);

    @Test
    public void testGetJSLibraries() {

        List<String> pageUrls = Arrays.asList("www.oracle.com", "www.java.com");
        Mockito.when(extractLibraries.getJSLibraries(pageUrls)).thenReturn(getLib());

        List<String> listLib = extractLibraries.getJSLibraries(pageUrls);

        Assert.assertEquals(24, listLib.size());
        Assert.assertEquals("angular.js", listLib.get(0));
    }

    @Test
    public void testGetJSLibrariesNotFound() {

        List<String> pageUrls = Arrays.asList("www.oracle.com");
        Mockito.when(extractLibraries.getJSLibraries(pageUrls)).thenReturn(null);

        List<String> listLib = extractLibraries.getJSLibraries(pageUrls);

        Assert.assertNull(listLib);
    }

    public List<String> getLib(){
        List<String> webjslib = new ArrayList<String>();
        webjslib.add("angular.js");
        webjslib.add("app.js");
        webjslib.add("app.js");
        webjslib.add("backbone.js");
        webjslib.add("jquery.js");
        webjslib.add("app.js");
        webjslib.add("node.js");
        webjslib.add("app.js");
        webjslib.add("react.js");
        webjslib.add("node.js");
        webjslib.add("angular.js");
        webjslib.add("react.js");
        webjslib.add("backbone.js");
        webjslib.add("google-adsense.js");
        webjslib.add("google-adsense.js");
        webjslib.add("google-adsense.js");
        webjslib.add("google-adsense.js");
        webjslib.add("google-adsense.js");
        webjslib.add("jquery.js");
        webjslib.add("jquery.js");
        webjslib.add("jquery.js");
        webjslib.add("jquery.js");
        webjslib.add("jquery.js");
        webjslib.add("jquery.js");
        return webjslib;
    }

}
