package it.contrader.dao;

import java.util.List;

public interface DAO<DTO> {

	public List<DTO> getAll();
	
	public DTO read(int id);
	
	public boolean insert(DTO dto);
	
	public boolean update(DTO dto);
	
	public boolean delete(int id);
}
