package com.goldenducks.carreco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goldenducks.carreco.entity.CarRecoResponse;
import com.goldenducks.carreco.service.CarRecoService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/carreco")
public class CarRecoController {
	
	@Autowired
	private CarRecoService carRecoService;
	
    @RequestMapping(value= "{searchText}", method=RequestMethod.GET)
    public @ResponseBody CarRecoResponse carReco(@PathVariable("searchText") String searchText) {
        
    	return carRecoService.getCareerRecommendation(searchText);
    }

}
