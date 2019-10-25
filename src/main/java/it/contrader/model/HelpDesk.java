package it.contrader.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "helpdesk")
public class HelpDesk {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "title")
	private String title;
	
	@NotNull
	@Column(name = "chat")
	private ArrayList<String> chat;
	
	@Column(name = "gestor")
	private Long gestor;
	
	@NotNull
	@Column(name = "reply")
	private Boolean reply;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="idUser", referencedColumnName="id")
	private User user;
	
	
}
