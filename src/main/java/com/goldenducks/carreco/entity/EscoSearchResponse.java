package com.goldenducks.carreco.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings({ "unchecked", "rawtypes" })
public class EscoSearchResponse {

	
	// map classname, title and uri of json to object
	@JsonProperty("_embedded")
    private void unpackNested(Map<String,Object> _embedded) {
		List<Map<String,Object>> results = (List)_embedded.get("results");
		for (Map<String,Object> result : results) {
			
			String className = (String)result.get("className");
			String title = (String)result.get("title");
			String uri = (String)result.get("uri");	
			
			if(this.results == null)
				this.results = new ArrayList<EscoSearchResponseResult>();
			this.results.add(new EscoSearchResponseResult(className,title,uri));
		}
    }
	
	private List<EscoSearchResponseResult> results;
	
	public List<EscoSearchResponseResult> getResults() {
		return results;
	}
	public void setResults(List<EscoSearchResponseResult> results) {
		this.results = results;
	}
	
	
}