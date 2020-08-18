package com.test.webscoop.websense;

import java.util.List;
import java.util.Map.Entry;

public interface WebAnalytics {
	
    List<Entry<String, Long>> getPopular(long n, List<String> attr);

}
