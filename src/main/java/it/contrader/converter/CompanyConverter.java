package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CompanyDTO;
import it.contrader.model.Company;

@Component
public class CompanyConverter extends AbstractConverter <Company,CompanyDTO>{

	@Override
	public Company toEntity(CompanyDTO companyDTO) {
		Company company = null;
		if (companyDTO != null) {
			company = new Company(companyDTO.getId(),companyDTO.getName(),companyDTO.getAddress(),companyDTO.getCity(),companyDTO.getSector());			
		}
		return company;
	}

	@Override
	public CompanyDTO toDTO(Company company) {
		CompanyDTO companyDTO = null;
		if (company != null) {
			companyDTO = new CompanyDTO(company.getId(),company.getName(),company.getAddress(),company.getCity(),company.getSector());
			
		}
		return companyDTO;
	}
}
