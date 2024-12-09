package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.ContractedOnDto;
import com.cpsc471g6.scplan.entity.ContractedOn;
import com.cpsc471g6.scplan.entity.ContractedOnId;

public class ContractedOnMapper {

	// Map ContractedOn entity to ContractedOnDto
	public static ContractedOnDto mapToContractedOnDto(ContractedOn contractedOn) {
		return new ContractedOnDto(
				contractedOn.getId().getProjectId(),
				contractedOn.getId().getContractDesignerId(),
				contractedOn.getProject() != null ? contractedOn.getProject().getProjectName() : null,
				contractedOn.getContractDesigner() != null ? contractedOn.getContractDesigner().getName() : null
		);
	}

	// Map ContractedOnDto to ContractedOn entity
	public static ContractedOn mapToContractedOn(ContractedOnDto contractedOnDto) {
		ContractedOn contractedOn = new ContractedOn();
		ContractedOnId contractedOnId = new ContractedOnId(contractedOnDto.getProjectId(), contractedOnDto.getContractDesignerId());
		contractedOn.setId(contractedOnId);

		// Note: The Project and ContractDesigner entities should be fetched and set in the service layer
		return contractedOn;
	}
}