package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.ContractedOnDto;
import com.cpsc471g6.scplan.service.ContractedOnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/contracted-on")
public class ContractedOnController {

	private final ContractedOnService contractedOnService;

	/**
	 * Create a ContractedOn relationship
	 */
	@PostMapping
	public ResponseEntity<ContractedOnDto> createContractedOn(@RequestBody ContractedOnDto contractedOnDto) {
		ContractedOnDto createdContractedOn = contractedOnService.createContractedOn(contractedOnDto);
		return new ResponseEntity<>(createdContractedOn, HttpStatus.CREATED);
	}

	/**
	 * Get a ContractedOn relationship by composite ID
	 */
	@GetMapping("/projects/{projectId}/contract-designers/{contractDesignerId}")
	public ResponseEntity<ContractedOnDto> getContractedOnById(
			@PathVariable int projectId,
			@PathVariable int contractDesignerId) {
		ContractedOnDto contractedOn = contractedOnService.getContractedOnById(projectId, contractDesignerId);
		return ResponseEntity.ok(contractedOn);
	}

	/**
	 * Get all ContractedOn relationships for a specific project
	 */
	@GetMapping("/projects/{projectId}")
	public ResponseEntity<List<ContractedOnDto>> getAllContractedOnByProject(@PathVariable int projectId) {
		List<ContractedOnDto> contractedOnList = contractedOnService.getAllContractedOnByProject(projectId);
		return ResponseEntity.ok(contractedOnList);
	}

	/**
	 * Get all ContractedOn relationships for a specific Contract Designer
	 */
	@GetMapping("/contract-designers/{contractDesignerId}")
	public ResponseEntity<List<ContractedOnDto>> getAllContractedOnByContractDesigner(@PathVariable int contractDesignerId) {
		List<ContractedOnDto> contractedOnList = contractedOnService.getAllContractedOnByContractDesigner(contractDesignerId);
		return ResponseEntity.ok(contractedOnList);
	}

	/**
	 * Get all ContractedOn relationships
	 */
	@GetMapping
	public ResponseEntity<List<ContractedOnDto>> getAllContractedOn() {
		List<ContractedOnDto> contractedOnList = contractedOnService.getAllContractedOn();
		return ResponseEntity.ok(contractedOnList);
	}

	/**
	 * Update a ContractedOn relationship
	 */
	@PutMapping("/projects/{projectId}/contract-designers/{contractDesignerId}")
	public ResponseEntity<ContractedOnDto> updateContractedOn(
			@PathVariable int projectId,
			@PathVariable int contractDesignerId,
			@RequestBody ContractedOnDto contractedOnDto) {
		ContractedOnDto updatedContractedOn = contractedOnService.updateContractedOn(projectId, contractDesignerId, contractedOnDto);
		return ResponseEntity.ok(updatedContractedOn);
	}

	/**
	 * Delete a ContractedOn relationship
	 */
	@DeleteMapping("/projects/{projectId}/contract-designers/{contractDesignerId}")
	public ResponseEntity<String> deleteContractedOn(
			@PathVariable int projectId,
			@PathVariable int contractDesignerId) {
		contractedOnService.deleteContractedOn(projectId, contractDesignerId);
		return new ResponseEntity<>("ContractedOn relationship deleted successfully", HttpStatus.OK);
	}
}