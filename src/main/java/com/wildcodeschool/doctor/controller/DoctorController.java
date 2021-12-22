package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable int number) {
    	
    	//retourne le Json ...
    	if (number == 13) {
    		return new Doctor(13, "Jodie Whittaker");
    	
    	// si doc 1 à 12 retourne status 303
    	}else if (number >= 1 && number <= 12) {
    		throw new ResponseStatusException(HttpStatus.SEE_OTHER);
    	
    	// si doc invalise retourne status 404
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossiblede récupérer l'incarnation" + number);
    	}

    }
}
