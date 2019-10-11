package it.contrader.converter;

import java.util.List;

/**
 * 
 * @author Vittorio
 *
 * @param <Entity>
 * @param <DTO>
 * 
 * Questa interfaccia firma i metodi dei converter (vedi guida JavaCOnsolePro, sez Interfacce e Clasi Astratte)
 */
public interface Converter<Entity, DTO> {

	public DTO toDTO(Entity entity);
	
	public Entity toEntity(DTO dto);
	
	public List<DTO> toDTOList(List<Entity> entityList);
}
