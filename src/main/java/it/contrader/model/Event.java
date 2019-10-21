package it.contrader.model;

import java.time.LocalDateTime;

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
@Table(name = "event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name ="name")
	private String name;
	
	@NotNull
	@Column(name ="description")
	private String description;
	
	@NotNull
	@Column(name ="category")
	private String category;
	
	@NotNull
	@Column(name ="xPosition")
	private float xPosition;
	
	@NotNull
	@Column(name ="yPosition")
	private float yPosition;
	
	@NotNull
	@Column(name ="startDate")
	private LocalDateTime startDate;
	
	@NotNull
	@Column(name ="endDate")
	private LocalDateTime endDate;
	
	@ManyToOne
	@JoinColumn(name ="idUser", referencedColumnName ="id")
	private User user;
	

}
