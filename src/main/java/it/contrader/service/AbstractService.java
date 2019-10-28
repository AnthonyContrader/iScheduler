package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.CrudRepository;

import it.contrader.converter.Converter;


/**
 * Questa classe astratta implementa tutti i metodi CRUD firmati in ServiceDTO.
 * Il converter agisce due volte nei metodi  insert e update per avere sia come input che come output
 * un oggetto DTO.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @param <Entity>
 * @param <DTO>
 * 
 * @see ServiceDTO
 */
public abstract class AbstractService<Entity,DTO> implements ServiceDTO<DTO> {
	
	@Autowired
	protected CrudRepository<Entity,Long> repository;
	@Autowired
	protected Converter<Entity,DTO> converter;
	
	@Override
	public DTO insert(DTO dto) {
		return converter.toDTO(repository.save(converter.toEntity(dto)));
	}

	@Override
	public Iterable<DTO> getAll() {
		return converter.toDTOList(repository.findAll());
	}

	@Override
	public DTO read(long id) {
		return converter.toDTO(repository.findById(id).get());
	}

	@Override
	public DTO update(DTO dto) {
		return converter.toDTO(repository.save(converter.toEntity(dto)));
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}
}