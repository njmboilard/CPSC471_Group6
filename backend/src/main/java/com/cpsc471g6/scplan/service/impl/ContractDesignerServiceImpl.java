package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.ContractDesignerDto;
import com.cpsc471g6.scplan.entity.ContractDesigner;
import com.cpsc471g6.scplan.entity.Contractor;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.ContractDesignerMapper;
import com.cpsc471g6.scplan.repository.ContractDesignerRepository;
import com.cpsc471g6.scplan.repository.ContractorRepository;
import com.cpsc471g6.scplan.service.ContractDesignerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ContractDesignerServiceImpl implements ContractDesignerService {
	private ContractDesignerRepository contractDesignerRepository;
	private ContractorRepository contractorRepository;

	@Override
	public ContractDesignerDto createContractDesigner(ContractDesignerDto contractDesignerDto, int contractorId) {
		// Fetch contractor
		Contractor contractor = contractorRepository.findById(contractorId).orElseThrow(
				() -> new ResourceNotFoundException("Contractor " + contractorId + " not found.")
		);

		// Map DTO to entity and set contractor
		ContractDesigner contractDesigner = ContractDesignerMapper.mapToContractDesigner(contractDesignerDto);
		contractDesigner.setContractor(contractor);

		// Save contract designer
		ContractDesigner savedContractDesigner = contractDesignerRepository.save(contractDesigner);
		return ContractDesignerMapper.mapToContractDesignerDto(savedContractDesigner);
	}

	@Override
	public ContractDesignerDto getContractDesignerById(int contractDesignerId) {
		// Fetch contract designer directly
		ContractDesigner contractDesigner = contractDesignerRepository.findById(contractDesignerId).orElseThrow(
				() -> new ResourceNotFoundException("Contract designer " + contractDesignerId + " not found.")
		);

		return ContractDesignerMapper.mapToContractDesignerDto(contractDesigner);
	}

	@Override
	public List<ContractDesignerDto> getAllContractDesigners() {
		List<ContractDesigner> contractDesigners = contractDesignerRepository.findAll();
		return contractDesigners.stream().map(ContractDesignerMapper::mapToContractDesignerDto).collect(Collectors.toList());
	}

	@Override
	public ContractDesignerDto updateContractDesigner(int contractDesignerId, ContractDesignerDto contractDesignerDto) {
		// Fetch the existing ContractDesigner entity
		ContractDesigner contractDesigner = contractDesignerRepository.findById(contractDesignerId).orElseThrow(
				() -> new ResourceNotFoundException("Contract designer " + contractDesignerId + " not found.")
		);

		// Check if Contractor ID is being updated
		if (contractDesignerDto.getContractorId() != contractDesigner.getContractor().getId()) {
			// Fetch the new Contractor entity
			Contractor newContractor = contractorRepository.findById(contractDesignerDto.getContractorId()).orElseThrow(
					() -> new ResourceNotFoundException("Contractor " + contractDesignerDto.getContractorId() + " not found.")
			);

			// Update the association
			contractDesigner.setContractor(newContractor);
		}

		// Update other fields
		contractDesigner.setName(contractDesignerDto.getName());

		// Save updated ContractDesigner
		ContractDesigner updatedContractDesigner = contractDesignerRepository.save(contractDesigner);

		// Map and return updated DTO
		return ContractDesignerMapper.mapToContractDesignerDto(updatedContractDesigner);
	}

	@Override
	public void deleteContractDesigner(int contractDesignerId) {
		// Ensure existence before deletion
		contractDesignerRepository.findById(contractDesignerId).orElseThrow(
				() -> new ResourceNotFoundException("Contract designer " + contractDesignerId + " not found.")
		);

		contractDesignerRepository.deleteById(contractDesignerId);
	}
}
