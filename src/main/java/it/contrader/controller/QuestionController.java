package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CompanyDTO;
import it.contrader.dto.QuestionDTO;
import it.contrader.service.QuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController extends AbstractController<QuestionDTO> {
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/getallbycompanies")
	public List<QuestionDTO> getAllByCompanies(@RequestBody CompanyDTO companyDTO){
		return questionService.getAllByCompany(companyDTO);
	}
}
