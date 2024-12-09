package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.ContractDesignerDto;

import java.util.List;

public interface ContractDesignerService {
	ContractDesignerDto createContractDesigner(ContractDesignerDto contractDesignerDto, int contractorId);

	ContractDesignerDto getContractDesignerById(int contractDesignerId);

	List<ContractDesignerDto> getAllContractDesigners();

	ContractDesignerDto updateContractDesigner(int contractDesignerId, ContractDesignerDto contractDesignerDto);

	void deleteContractDesigner(int contractDesignerId);
}