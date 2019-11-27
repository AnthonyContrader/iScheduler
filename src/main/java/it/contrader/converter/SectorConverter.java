package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.SectorDTO;
import it.contrader.model.Sector;

@Component

public class SectorConverter extends AbstractConverter<Sector,SectorDTO> {
	
	@Autowired
	private CompanyConverter cConverter;
	
@Override
public Sector toEntity(SectorDTO sectorDTO) {
	
	Sector sector=null;
	if(sectorDTO!=null) {
		sector = new Sector(sectorDTO.getId(),sectorDTO.getName(),cConverter.toEntity(sectorDTO.getCompanyDTO()));
		
	}
	return sector;
}

public SectorDTO toDTO(Sector sector){
	SectorDTO sectorDTO = null;
	if(sector!=null) {
		sectorDTO = new SectorDTO(sector.getId(),sector.getName(),cConverter.toDTO(sector.getCompany()));
	}
	return sectorDTO;
}

	

}
