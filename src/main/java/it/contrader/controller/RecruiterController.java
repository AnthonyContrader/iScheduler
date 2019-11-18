package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.RecruiterDTO;
import it.contrader.service.RecruiterService;



@RestController
@RequestMapping("/recruiter")
@CrossOrigin(origins = "http://localhost:4200")
public class RecruiterController extends AbstractController<RecruiterDTO>{
	
	@Autowired
	private RecruiterService recruiterService;
}