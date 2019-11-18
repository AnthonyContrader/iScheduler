package it.contrader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String question;
	
	@NotNull
	private String topic;
	
	@NotNull
	private String sector;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name = "recruiterId", referencedColumnName = "id")
	private Recruiter recruiter;
	
	@Nullable
	@ManyToOne
	@JoinColumn(name = "companyId", referencedColumnName = "id")
	private Company company;
}
