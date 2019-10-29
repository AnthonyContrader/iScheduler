package it.contrader.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "eventhistory")
public class EventHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "category")
	private String category;

	@NotNull
	@Column(name = "agentname")
	private String agentName;

	@NotNull
	@Column(name = "agentsurname")
	private String agentSurname;

	@NotNull
	@Column(name = "company")
	private String company;

	// Indicates the result of the interview, it can be positive or negative result
	@NotNull
	@Column(name = "result")
	private Boolean result;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "iduser", referencedColumnName = "id")
	private User user;

}

