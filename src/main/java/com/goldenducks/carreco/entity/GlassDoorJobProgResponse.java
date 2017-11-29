package com.goldenducks.carreco.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings({ "unchecked" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlassDoorJobProgResponse {

	private double payLow;
	private double payMedian;
	private double payHigh;
	private List<GlassDoorJobProgResponseNextJob> results;

	public double getPayLow() {
		return payLow;
	}

	public double getPayMedian() {
		return payMedian;
	}

	public double getPayHigh() {
		return payHigh;
	}

	public List<GlassDoorJobProgResponseNextJob> getResults() {
		return results;
	}

	// nested json to properties
	@JsonProperty("response")
	private void unpackNested(Map<String, Object> response) {
		
		this.payLow = response.get("payLow").equals("")? 0:(double) response.get("payLow");
		this.payMedian = response.get("payMedian").equals("")? 0:(double)response.get("payMedian");
		this.payHigh = response.get("payHigh").equals("")? 0:(double)response.get("payHigh");
		this.results = (List<GlassDoorJobProgResponseNextJob>)response.get("results");
	}

}
