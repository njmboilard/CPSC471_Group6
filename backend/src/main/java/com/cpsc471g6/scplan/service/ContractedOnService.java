package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.ContractedOnDto;

import java.util.List;

public interface ContractedOnService {
	// Create a ContractedOn relationship
	ContractedOnDto createContractedOn(ContractedOnDto contractedOnDto);

	// Get a ContractedOn relationship by Project ID and Contract Designer ID
	ContractedOnDto getContractedOnById(int projectId, int contractDesignerId);

	// Get all ContractedOn relationships for a specific project
	List<ContractedOnDto> getAllContractedOnByProject(int projectId);

	// Get all ContractedOn relationships for a specific contract designer
	List<ContractedOnDto> getAllContractedOnByContractDesigner(int contractDesignerId);

	// Get all ContractedOn relationships
	List<ContractedOnDto> getAllContractedOn();

	// Update a ContractedOn relationship by Project ID and Contract Designer ID
	ContractedOnDto updateContractedOn(int projectId, int contractDesignerId, ContractedOnDto contractedOnDto);

	// Delete a ContractedOn relationship by Project ID and Contract Designer ID
	void deleteContractedOn(int projectId, int contractDesignerId);
}