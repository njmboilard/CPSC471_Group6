package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.ContractorDto;
import com.cpsc471g6.scplan.entity.Contractor;

import java.util.stream.Collectors;

public class ContractorMapper {

	// Map Contractor entity to ContractorDto
	public static ContractorDto mapToContractorDto(Contractor contractor) {
		if (contractor == null) {
			return null;
		}

		return new ContractorDto(
				contractor.getId(),
				contractor.getName(),
				contractor.getContractDesigners() != null
						? contractor.getContractDesigners().stream()
						.map(ContractDesignerMapper::mapToContractDesignerDto)
						.collect(Collectors.toList())
						: null
		);
	}

	// Map ContractorDto to Contractor entity
	public static Contractor mapToContractor(ContractorDto contractorDto) {
		if (contractorDto == null) {
			return null;
		}

		Contractor contractor = new Contractor();
		contractor.setId(contractorDto.getId());
		contractor.setName(contractorDto.getName());
		// ContractDesigner mapping should be handled in the service layer
		return contractor;
	}
}