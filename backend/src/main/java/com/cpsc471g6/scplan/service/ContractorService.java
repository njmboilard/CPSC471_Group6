package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.ContractorDto;

import java.util.List;

public interface ContractorService {
	ContractorDto createContractor(ContractorDto contractorDto);

	ContractorDto getContractorById(int contractorId);

	List<ContractorDto> getAllContractors();

	ContractorDto updateContractor(int contractorId, ContractorDto contractorDto);

	void deleteContractor(int contractorId);
}
