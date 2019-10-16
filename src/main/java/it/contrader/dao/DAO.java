package it.contrader.dao;

import java.util.List;

public interface DAO<DTO> {

	public List<DTO> getAll();
	
	public List<DTO> getAllById(int id);
	
	public List<DTO> getAllByUser(int id);
	
	public DTO read(int id);
	
	public boolean insert(DTO dto);
	
	public boolean update(DTO dto);
	
	public boolean delete(int id);
}
