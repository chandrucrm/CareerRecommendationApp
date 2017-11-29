package com.goldenducks.carreco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.goldenducks.carreco.entity.CarRecoResponse;
import com.goldenducks.carreco.entity.EscoOccupationResponse;
import com.goldenducks.carreco.entity.EscoSearchResponse;
import com.goldenducks.carreco.entity.EscoSearchResponseResult;
import com.goldenducks.carreco.entity.GlassDoorJobProgResponse;
import com.goldenducks.carreco.entity.GlassDoorJobProgResponseNextJob;
import com.goldenducks.carreco.utils.CarRecoUtils;

@Service
public class CarRecoService {

	public CarRecoResponse getCareerRecommendation(String searchText) {

		// restTemplate used to call APIs
		RestTemplate restTemplate = new RestTemplate();

		// response that will be returned
		CarRecoResponse carRecoResponse = new CarRecoResponse();

		// API Url - to be moved to property file and fetched from there
		String escoSearchUrl = "https://ec.europa.eu/esco/api/search?text=";
		String escoOccupationUrl = "https://ec.europa.eu/esco/api/resource/occupation?uri=";
		String glassDoorJobProgUrl = "http://api.glassdoor.com/api/api.htm?t.p=231462&t.k=he3OQy2R2H9&userip=0.0.0.0&useragent=&format=json&v=1&action=jobs-prog&countryId=1&jobTitle=";

		// Esco Full Text Search - Quick Mode - First API call
		EscoSearchResponse escoSearchResponse = restTemplate.getForObject(escoSearchUrl + searchText,
				EscoSearchResponse.class);

		if (escoSearchResponse.getResults() != null && !escoSearchResponse.getResults().isEmpty()) {

			// first Occupation result from the resultset is filtered using getFirst Utils
			// function
			EscoSearchResponseResult firstOccupationResult = CarRecoUtils.getFirst(escoSearchResponse.getResults(),
					"className", "Occupation");
			if (firstOccupationResult != null)

				// Title from first occupation result is set to response title
				carRecoResponse.setTitle(firstOccupationResult.getTitle());

			// Esco Get Occupation - Second API call
			EscoOccupationResponse escoOccupationResponse = restTemplate
					.getForObject(escoOccupationUrl + firstOccupationResult.getUri(), EscoOccupationResponse.class);

			// Essential and Optional Skills from Occupation API is set to response
			if (escoOccupationResponse != null) {
				carRecoResponse.setEssentialSkills(escoOccupationResponse.getEssentialSkills());
				carRecoResponse.setOptionalSkills(escoOccupationResponse.getOptionalSkills());
			}

			// GlassDoor Job Progression - Third API call
			GlassDoorJobProgResponse glassDoorJobProgResponse = restTemplate.getForObject(
					glassDoorJobProgUrl + firstOccupationResult.getTitle(), GlassDoorJobProgResponse.class);

			// Job Prog result is ordered and saved to response
			if (glassDoorJobProgResponse != null) {
				carRecoResponse.setPayLow(glassDoorJobProgResponse.getPayLow());
				carRecoResponse.setPayMedian(glassDoorJobProgResponse.getPayMedian());
				carRecoResponse.setPayHigh(glassDoorJobProgResponse.getPayHigh());

				// Next Jobs are sorted based on medianSalary using Utils function
				List<GlassDoorJobProgResponseNextJob> nextJobs = new ArrayList<GlassDoorJobProgResponseNextJob>();
				nextJobs = glassDoorJobProgResponse.getResults();
				
				CarRecoUtils.sort(nextJobs, true, "medianSalary");

				carRecoResponse.setnextJobs(glassDoorJobProgResponse.getResults());

			}

		}
		return carRecoResponse;
	}

}
