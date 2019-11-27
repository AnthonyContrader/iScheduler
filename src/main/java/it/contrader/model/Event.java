package it.contrader.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "description")
	private String description;


	@NotNull
	@Column(name = "arguments")
	private String arguments;

	@NotNull
	@Column(name = "startDate")
	private LocalDateTime startDate;

	@NotNull
	@Column(name = "category")
	private String category;
	
	@NotNull
	@Column(name = "endDate")
	private LocalDateTime endDate;
	
	@NotNull
	@Column(name = "agentName")
	private String agentName;
	
	@NotNull
	@Column(name = "agentSurname")
	private String agentSurname;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idUser", referencedColumnName = "id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idCompany", referencedColumnName = "id")
	private Company company;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idSector", referencedColumnName = "id")
	private Sector sector;
	
	/*@OneToMany(mappedBy = "event", cascade = CascadeType.MERGE)
	private List<Notification> notifications;*/
}
