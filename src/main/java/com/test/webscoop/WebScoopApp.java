package com.test.webscoop;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import com.test.webscoop.Error.NoSearchResultsFound;
import com.test.webscoop.js.ExtractLibraries;
import com.test.webscoop.js.ExtractLibrariesImpl;
import com.test.webscoop.searchengine.BingSearch;
import com.test.webscoop.searchengine.SearchEngine;
import com.test.webscoop.websense.WebAnalytics;
import com.test.webscoop.websense.WebJSLibAnalytics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebScoopApp {

	private static final Logger logger = LoggerFactory.getLogger(WebScoopApp.class);
	private final WebAnalytics webAnalytics = new WebJSLibAnalytics();
	private final ExtractLibraries extLibraries = new ExtractLibrariesImpl();
	private final SearchEngine bingSearch = new BingSearch();


	public static void main(String[] args) throws IOException {
		String searchWord = null;
		if(args.length > 0){
			searchWord = args[0];
		}
		else{
			logger.warn("Please enter a search keyword");
			return;
		}

		final WebScoopApp webapp = new WebScoopApp();
		webapp.getResults(searchWord);
	}

	public List<Entry<String, Long>> getResults(String searchkey) throws IOException {
		logger.info("Entered search keyword : "+searchkey);
		List<Entry<String, Long>> popularJsList;
		List<String> webPageURLs = bingSearch.getWebPageLinks(searchkey);
		if (webPageURLs != null && webPageURLs.size() == 0){
			throw new NoSearchResultsFound("No results found");
		} else {
			List<String> jsLibList = extLibraries.getJSLibraries(webPageURLs);
			if (jsLibList.size() == 0){
				throw new NoSearchResultsFound("No results found");
			} else {
				popularJsList = webAnalytics.getPopular(5, jsLibList);
				logger.info("Most used js libraries list"+popularJsList);
			}
		}
		return popularJsList;
	}

}
