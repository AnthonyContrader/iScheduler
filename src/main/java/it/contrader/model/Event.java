package it.contrader.model;
import java.sql.Date;

public class Event {
	
	private int id,idUser;
	private float posizioneX,posizioneY;
	private Date scadenza;
	private String nome,descrizione,categoria;
	
	public Event() {
		
	}
	
	public Event(float posizioneX, float posizioneY, Date scadenza, String nome, String descrizione, String categoria) {
		this.posizioneX = posizioneX;
		this.posizioneY = posizioneY;
		this.scadenza = scadenza;
		this.nome = nome;
		this.descrizione = descrizione;
		this.categoria = categoria;
		
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCategoria() {
		return this.categoria;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Evento: "+this.nome+"con ID: "+this.id +" "+ this.scadenza+"\tDescrzione: "+
				this.descrizione+" Categoria: "+this.categoria +"\tPosizione (X : "+this.posizioneX+","+this.posizioneY+")\t";
	    
	}
	@Override
	public boolean equals(Object o) {
		if(this == o ) return true;
		if(o == null ) return false;
		if(this.getClass() != o.getClass()) return false;
		Event ev = (Event)o;
		if(ev.id != this.id) return false;
		if(ev.categoria != this.categoria) return false;
		if(ev.posizioneX != this.posizioneX || ev.posizioneY != this.posizioneY ) return false;
		if(ev.scadenza != this.scadenza) return false;
		if(!ev.nome.equals(this.nome) || !ev.descrizione.equals(this.descrizione)) return false;
		return true;
	}

}
