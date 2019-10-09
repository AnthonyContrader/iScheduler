package it.contrader.model;

import java.sql.Date;

public class Event {

	private int id, idUser;
	private float posizioneX, posizioneY;
	private Date scadenza;
	private String nome, descrizione, categoria;

	public Event() {
		
	}

	public Event(int id,float posizioneX, float posizioneY, Date scadenza, String nome, String descrizione,
			String categoria) {
		super();
		this.id = id;
		this.posizioneX = posizioneX;
		this.posizioneY = posizioneY;
		this.scadenza = scadenza;
		this.nome = nome;
		this.descrizione = descrizione;
		this.categoria = categoria;
	}

	public Event(float posizioneX, float posizioneY, Date scadenza, String nome, String descrizione,
			String categoria) {
		super();
		this.posizioneX = posizioneX;
		this.posizioneY = posizioneY;
		this.scadenza = scadenza;
		this.nome = nome;
		this.descrizione = descrizione;
		this.categoria = categoria;
	}
	
	public Event(int id,int idUser,float posizioneX, float posizioneY, Date scadenza, String nome, String descrizione,
			String categoria) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + id;
		result = prime * result + idUser;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Float.floatToIntBits(posizioneX);
		result = prime * result + Float.floatToIntBits(posizioneY);
		result = prime * result + ((scadenza == null) ? 0 : scadenza.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (id != other.id)
			return false;
		if (idUser != other.idUser)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Float.floatToIntBits(posizioneX) != Float.floatToIntBits(other.posizioneX))
			return false;
		if (Float.floatToIntBits(posizioneY) != Float.floatToIntBits(other.posizioneY))
			return false;
		if (scadenza == null) {
			if (other.scadenza != null)
				return false;
		} else if (!scadenza.equals(other.scadenza))
			return false;
		return true;
	}
	

}
