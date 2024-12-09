package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.ContractorDto;
import com.cpsc471g6.scplan.entity.ContractDesigner;
import com.cpsc471g6.scplan.entity.Contractor;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.ContractDesignerMapper;
import com.cpsc471g6.scplan.mapper.ContractorMapper;
import com.cpsc471g6.scplan.repository.ContractorRepository;
import com.cpsc471g6.scplan.service.ContractorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ContractorServiceImpl implements ContractorService {
	private ContractorRepository contractorRepository;

	@Override
	public ContractorDto createContractor(ContractorDto contractorDto) {
		Contractor contractor = ContractorMapper.mapToContractor(contractorDto);

		if (contractorDto.getContractDesigners() != null) {
			List<ContractDesigner> contractDesigners = contractorDto.getContractDesigners().stream()
					.map(contractDesignerDto -> {
						ContractDesigner contractDesigner = ContractDesignerMapper.mapToContractDesigner(contractDesignerDto);
						contractDesigner.setContractor(contractor);
						return contractDesigner;
					})
					.collect(Collectors.toList());
			contractor.setContractDesigners(contractDesigners);
		}
		Contractor savedContractor = contractorRepository.save(contractor);
		return ContractorMapper.mapToContractorDto(savedContractor);
	}

	@Override
	public ContractorDto getContractorById(int contractorId) {
		Contractor contractor = contractorRepository.findById(contractorId).orElseThrow(
				() -> new ResourceNotFoundException("Contractor " + contractorId + " not found.")
		);
		return ContractorMapper.mapToContractorDto(contractor);
	}

	@Override
	public List<ContractorDto> getAllContractors() {
		List<Contractor> contractors = contractorRepository.findAll();
		return contractors.stream().map(ContractorMapper::mapToContractorDto).collect(Collectors.toList());
	}

	@Override
	public ContractorDto updateContractor(int contractorId, ContractorDto contractorDto) {
		Contractor contractor = contractorRepository.findById(contractorId).orElseThrow(
				() -> new ResourceNotFoundException("Contractor " + contractorId + " not found.")
		);

		contractor.setName(contractorDto.getName());

		Contractor updatedContractorObj = contractorRepository.save(contractor);
		return ContractorMapper.mapToContractorDto(updatedContractorObj);
	}

	@Override
	public void deleteContractor(int contractorId) {
		Contractor contractor = contractorRepository.findById(contractorId).orElseThrow(
				() -> new ResourceNotFoundException("Contractor " + contractorId + " not found.")
		);
		contractorRepository.deleteById(contractorId);
	}
}
