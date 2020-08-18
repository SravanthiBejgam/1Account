package com.test.webscoop.searchengine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BingSearch implements SearchEngine {

	private static final Logger logger = LoggerFactory.getLogger(BingSearch.class);
	private static final int RESULT_LIMIT = 10;
	private static final int TIMEOUT = 10000;

	private static String BING_SEARCH_URL = "https://www.bing.com/search?count=" + RESULT_LIMIT + "&q=";

	@Override
	public List<String> getWebPageLinks(String keyword) {
		List<String> webPages = new ArrayList<String>();
		try {
			Document document = Jsoup
					.connect(BING_SEARCH_URL + keyword	)
					.timeout(TIMEOUT)
					.get();
			// Extracting the a href from H2 heading from the document page
			Elements result = document.select("li.b_algo h2 a");
			for (Element res : result) {
				String linkHref = res.attr("href");
				webPages.add(linkHref);
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return webPages.stream().distinct().collect(Collectors.toList());
	}
}
