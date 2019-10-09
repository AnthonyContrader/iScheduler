package it.contrader.dto;

import java.sql.Date;

public class EventDTO {

	private int id, idUser;
	private float posizioneX, posizioneY;
	private Date scadenza;
	private String nome, descrizione, categoria;

	public EventDTO() {

	}

	public EventDTO(int idUser, float posizioneX, float posizioneY, Date scadenza, String nome, String descrizione,
			String categoria) {
		super();
		this.idUser = idUser;
		this.posizioneX = posizioneX;
		this.posizioneY = posizioneY;
		this.scadenza = scadenza;
		this.nome = nome;
		this.descrizione = descrizione;
		this.categoria = categoria;
	}

	public EventDTO(int id, int idUser, float posizioneX, float posizioneY, Date scadenza, String nome,
			String descrizione, String categoria) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.posizioneX = posizioneX;
		this.posizioneY = posizioneY;
		this.scadenza = scadenza;
		this.nome = nome;
		this.descrizione = descrizione;
		this.categoria = categoria;
	}
	
	public EventDTO(float posizioneX, float posizioneY, Date scadenza, String nome,
			String descrizione, String categoria) {
		super();
		this.posizioneX = posizioneX;
		this.posizioneY = posizioneY;
		this.scadenza = scadenza;
		this.nome = nome;
		this.descrizione = descrizione;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public float getPosizioneX() {
		return posizioneX;
	}

	public void setPosizioneX(float posizioneX) {
		this.posizioneX = posizioneX;
	}

	public float getPosizioneY() {
		return posizioneY;
	}

	public void setPosizioneY(float posizioneY) {
		this.posizioneY = posizioneY;
	}

	public Date getScadenza() {
		return scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return id+"\t"+"\t"+nome+"\t"+categoria+"\t\t"+descrizione+"\t"+scadenza+"\t"+posizioneX+","+posizioneY+"\t"+idUser;
	}
}