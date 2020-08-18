package com.test.webscoop.Error;

public class NoSearchResultsFound extends RuntimeException {
    public NoSearchResultsFound(String errorMessage){
        super(errorMessage);
    }

}
