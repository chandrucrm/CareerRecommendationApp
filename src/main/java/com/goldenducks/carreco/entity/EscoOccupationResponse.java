package com.goldenducks.carreco.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings({ "unchecked", "rawtypes" })
public class EscoOccupationResponse {
	
	// map skills to object
		@JsonProperty("_links")
	    private void unpackNested(Map<String,Object> _embedded) {
			List<Map<String,Object>> essentialsSkills = (List)_embedded.get("hasEssentialSkill");
			List<Map<String,Object>> optionalSkills = (List)_embedded.get("hasOptionalSkill");
			
			this.essentialSkills = getSkills(essentialsSkills);
			this.optionalSkills = getSkills(optionalSkills);
	    }
		
		private List<String> getSkills(List<Map<String,Object>> skills){
			List<String> skillsList = new ArrayList<String>();
			for (Map<String,Object> skill : skills) {
				skillsList.add((String)skill.get("title"));
			}
			return skillsList;
		}
		
		private List<String> essentialSkills;
		private List<String> optionalSkills;
		public List<String> getEssentialSkills() {
			return essentialSkills;
		}

		public List<String> getOptionalSkills() {
			return optionalSkills;
		}

}
