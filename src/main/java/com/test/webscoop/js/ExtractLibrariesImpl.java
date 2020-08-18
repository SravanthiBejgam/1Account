package com.test.webscoop.js;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtractLibrariesImpl implements ExtractLibraries {

	private static final Logger logger = LoggerFactory.getLogger(ExtractLibrariesImpl.class);
	private static final String REGEX = "\\?.*";
	private static final int TIMEOUT = 10000;

	@Override
	public List<String> getJSLibraries(List<String> pageUrls) {
		// TODO Auto-generated method stub
		List<String> webjslib = new ArrayList<String>();
		for (String res : pageUrls) {

			Document document;

			try {
				document = Jsoup.connect(res).timeout(TIMEOUT).ignoreContentType(true).ignoreHttpErrors(true).get();
				final Elements elements = document.select("script");

				// Extracting the src attribute with js extension
				for (final Element element : elements) {
					final String src = element.attr("src");
					if (src != null && src.length() > 0 && src.contains(".js")) {
						// Extracting only js out of the URL
						String sanitizedScript = src.substring(src.lastIndexOf("/") + 1).replaceFirst(REGEX, "");
						webjslib.add(sanitizedScript);
					}
				}
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return webjslib;
	}

}
