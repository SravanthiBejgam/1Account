package com.test.webscoop.websense;

import com.test.webscoop.searchengine.BingSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WebJSLibAnalytics implements WebAnalytics {

	private static final Logger logger = LoggerFactory.getLogger(WebJSLibAnalytics.class);

	@Override
	public List<Entry<String, Long>> getPopular(long n, List<String> attr) {
		// TODO Auto-generated method stub
		return attr.stream()
	            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
	            .entrySet()
	            .stream()
	            .sorted((o1, o2) ->  o2.getValue().compareTo(o1.getValue()))
	            .limit(n)
	            .collect(Collectors.toList());
	}

}
