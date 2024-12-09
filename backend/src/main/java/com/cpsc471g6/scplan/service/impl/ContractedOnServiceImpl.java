package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.ContractedOnDto;
import com.cpsc471g6.scplan.entity.ContractedOn;
import com.cpsc471g6.scplan.entity.ContractedOnId;
import com.cpsc471g6.scplan.entity.ContractDesigner;
import com.cpsc471g6.scplan.entity.Project;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.ContractedOnMapper;
import com.cpsc471g6.scplan.repository.ContractedOnRepository;
import com.cpsc471g6.scplan.repository.ContractDesignerRepository;
import com.cpsc471g6.scplan.repository.ProjectRepository;
import com.cpsc471g6.scplan.service.ContractedOnService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContractedOnServiceImpl implements ContractedOnService {

	private final ContractedOnRepository contractedOnRepository;
	private final ProjectRepository projectRepository;
	private final ContractDesignerRepository contractDesignerRepository;

	@Override
	public ContractedOnDto createContractedOn(ContractedOnDto contractedOnDto) {
		// Fetch project and contract designer
		Project project = projectRepository.findById(contractedOnDto.getProjectId())
				.orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + contractedOnDto.getProjectId()));
		ContractDesigner contractDesigner = contractDesignerRepository.findById(contractedOnDto.getContractDesignerId())
				.orElseThrow(() -> new ResourceNotFoundException("Contract Designer not found with ID: " + contractedOnDto.getContractDesignerId()));

		// Map DTO to Entity
		ContractedOn contractedOn = ContractedOnMapper.mapToContractedOn(contractedOnDto);
		contractedOn.setProject(project);
		contractedOn.setContractDesigner(contractDesigner);

		// Save entity
		ContractedOn savedContractedOn = contractedOnRepository.save(contractedOn);

		// Map to DTO and return
		return ContractedOnMapper.mapToContractedOnDto(savedContractedOn);
	}

	@Override
	public ContractedOnDto getContractedOnById(int projectId, int contractDesignerId) {
		ContractedOnId id = new ContractedOnId(projectId, contractDesignerId);
		ContractedOn contractedOn = contractedOnRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ContractedOn relationship not found for projectId: " + projectId + " and contractDesignerId: " + contractDesignerId));
		return ContractedOnMapper.mapToContractedOnDto(contractedOn);
	}

	@Override
	public List<ContractedOnDto> getAllContractedOnByProject(int projectId) {
		// Filter by project ID
		return contractedOnRepository.findAll().stream()
				.filter(contractedOn -> contractedOn.getProject().getId() == projectId)
				.map(ContractedOnMapper::mapToContractedOnDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ContractedOnDto> getAllContractedOnByContractDesigner(int contractDesignerId) {
		// Filter by contract designer ID
		return contractedOnRepository.findAll().stream()
				.filter(contractedOn -> contractedOn.getContractDesigner().getId() == contractDesignerId)
				.map(ContractedOnMapper::mapToContractedOnDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ContractedOnDto> getAllContractedOn() {
		// Fetch all relationships
		return contractedOnRepository.findAll().stream()
				.map(ContractedOnMapper::mapToContractedOnDto)
				.collect(Collectors.toList());
	}

	@Override
	public ContractedOnDto updateContractedOn(int projectId, int contractDesignerId, ContractedOnDto contractedOnDto) {
		ContractedOnId id = new ContractedOnId(projectId, contractDesignerId);

		// Fetch the existing relationship
		ContractedOn existingContractedOn = contractedOnRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ContractedOn relationship not found for projectId: " + projectId + " and contractDesignerId: " + contractDesignerId));

		// Update fields (if needed)
		if (contractedOnDto.getProjectName() != null) {
			Project project = projectRepository.findById(contractedOnDto.getProjectId())
					.orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + contractedOnDto.getProjectId()));
			existingContractedOn.setProject(project);
		}

		if (contractedOnDto.getContractDesignerName() != null) {
			ContractDesigner contractDesigner = contractDesignerRepository.findById(contractedOnDto.getContractDesignerId())
					.orElseThrow(() -> new ResourceNotFoundException("Contract Designer not found with ID: " + contractedOnDto.getContractDesignerId()));
			existingContractedOn.setContractDesigner(contractDesigner);
		}

		// Save updated entity
		ContractedOn updatedContractedOn = contractedOnRepository.save(existingContractedOn);

		// Return updated DTO
		return ContractedOnMapper.mapToContractedOnDto(updatedContractedOn);
	}

	@Override
	public void deleteContractedOn(int projectId, int contractDesignerId) {
		ContractedOnId id = new ContractedOnId(projectId, contractDesignerId);

		// Ensure the relationship exists
		ContractedOn contractedOn = contractedOnRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ContractedOn relationship not found for projectId: " + projectId + " and contractDesignerId: " + contractDesignerId));

		// Delete the relationship
		contractedOnRepository.delete(contractedOn);
	}
}