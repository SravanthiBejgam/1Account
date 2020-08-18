package com.test.webscoop.searchengine;

import java.io.IOException;
import java.util.List;

public interface SearchEngine {
	List<String> getWebPageLinks(String keyword) throws IOException;
}
