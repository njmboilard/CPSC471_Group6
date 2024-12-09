package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.ContractDesignerDto;
import com.cpsc471g6.scplan.entity.ContractDesigner;
import com.cpsc471g6.scplan.entity.Contractor;

import java.util.Collections;
import java.util.stream.Collectors;

public class ContractDesignerMapper {

	public static ContractDesignerDto mapToContractDesignerDto(ContractDesigner contractDesigner) {
		return new ContractDesignerDto(
				contractDesigner.getId(),
				contractDesigner.getName(),
				contractDesigner.getContractor().getId(),
				contractDesigner.getContractedOnList() != null
					? contractDesigner.getContractedOnList().stream().map(ContractedOnMapper::mapToContractedOnDto).collect(Collectors.toList())
					: Collections.emptyList()
		);
	}

	public static ContractDesigner mapToContractDesigner(ContractDesignerDto contractDesignerDto) {
		ContractDesigner contractDesigner = new ContractDesigner();
		contractDesigner.setName(contractDesignerDto.getName());
		return contractDesigner;
	}
}