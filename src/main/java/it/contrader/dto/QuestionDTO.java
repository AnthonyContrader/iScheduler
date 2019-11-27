package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.Company;
import it.contrader.model.Recruiter;
import it.contrader.model.Sector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class QuestionDTO {
	private long id;
	private String question;
	private String topic;
	//private String sector;
	private RecruiterDTO recruiterDTO;
	private CompanyDTO companyDTO;
	private SectorDTO sectorDTO;
}
